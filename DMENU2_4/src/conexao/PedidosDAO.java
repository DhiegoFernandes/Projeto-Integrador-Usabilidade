package conexao;

import negocio.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosDAO {

    public List<Pedido> buscaPorPedido(int idpedido) throws SQLException {//obtem pedido pelo codigo do id do pedido

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de carros para retornar
        List<Pedido> listaDePedidos = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de carros
            String sql = "select * from pedido WHERE idPedido LIKE ?;";/*#####################################
                                                                              ESTÁ LISTANDO POR NUMERO DO PEDIDO, 
                                                                              ALTERAR PARA LISTAR POR OUTRA COISA */

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + idpedido + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Pedido ped = new Pedido(); //Criando uma instância, novo carro na memória

                ped.setIdpedido(resultado.getInt("idpedido")); // Define ID do pedido;
                ped.setFk_pedido_mesa(resultado.getInt("fk_pedido_mesa")); // Define fk da mesa
                ped.setTotal(resultado.getDouble("total")); // Define precoTotal 
                ped.setData(resultado.getString("data")); // Define data
                ped.setStatus(resultado.getString("status")); // Define status

                // Insere o pedido na lista Local
                listaDePedidos.add(ped);
            }

            // Retorna a lista de carros
            return listaDePedidos;
        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return null;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            resultado.close();
            stmt.close();
            con.getConexao().close();
        }
    }

    public List<Pedido> listaTodosOsPedidos() throws SQLException {//obtem pizza pelo codigo do atendente

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de pedidos para retornar
        List<Pedido> listaDePedidos = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de carros
            String sql = "select * from pedido;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            //stmt.setString(1, "%" + codAtendente + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Pedido ped = new Pedido(); //Criando uma instância, novo pedido na memória

                ped.setIdpedido(resultado.getInt("idpedido")); // Define ID do pedido;
                ped.setFk_pedido_mesa(resultado.getInt("fk_pedido_mesa")); // Define fk da mesa
                ped.setTotal(resultado.getDouble("total")); // Define precoTotal 
                ped.setData(resultado.getString("data")); // Define data
                ped.setStatus(resultado.getString("status")); // Define status

                // Insere a pedido na lista Local
                listaDePedidos.add(ped);
            }

            // Retorna a lista de carros
            return listaDePedidos;
        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return null;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            resultado.close();
            stmt.close();
            con.getConexao().close();
        }
    }

    public void inserePedido(Pedido ped) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO pedido"
                    + "(idpedido, fk_pedido_mesa, total, status)" //4 VALORES
                    + "VALUES"
                    + "(?, ?, ?,  ?)"; //4 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, ped.getIdpedido());
            st.setInt(2, ped.getFk_pedido_mesa());
            st.setDouble(3, ped.getTotal());
            //st.setString(4, ped.getData()); data é default_generated no banco de dados, não precisa inserir
            st.setString(4, ped.getStatus());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    ped.setIdpedido(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (SQLException e) {
            System.out.println("antes da msg");
            JOptionPane.showMessageDialog(null, "Pedido não foi criado!");
            System.out.println(e.getMessage());
            System.out.println("depois");
        } finally {
            conexao.fechaConexao();
        }

    }

    public void adicionaCarrinho(Pedido pz) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO pedido"
                    + "(idMesa)" //1 VALORES
                    + "VALUES"
                    + "(?)"; //4 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setDouble(1, pz.getIdMesa());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    pz.setIdPedido(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pedido não foi criado! verifique se o atendente existe.");
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    }

    public Pedido buscaPorID(int id, Pedido pz) {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from pedido "
                    + "WHERE idPedido = ?";

            //define query sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            st.setInt(1, id);
            rs = st.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

                pz.setIdPedido(rs.getInt("idPedido"));
                pz.setStatus(rs.getString("status"));
                pz.setPrecoTotal(rs.getDouble("precoTotal"));
                pz.setIdMesa(rs.getInt("idMesa"));

                return pz;
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
        return null;
    }
    
    
    /*     public void criaPedido(Pedido pz) {
    
    Conexao conexao = new Conexao();
    PreparedStatement st = null;
    
    try {
    String sql = "";
    sql += "";
    sql += "INSERT INTO pedido"
    + "(idMesa)" //1 VALORES
    + "VALUES"
    + "(?)"; //4 INTERROGAÇOES
    
    st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    
    st.setDouble(1, pz.getIdMesa());
    
    int linhasAfetadas = st.executeUpdate();
    
    if (linhasAfetadas > 0) {
    ResultSet rs = st.getGeneratedKeys();
    if (rs.next()) {
    int id = rs.getInt(1);
    pz.setIdPedido(id);
    }
    rs.close();
    } else {
    throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
    }
    
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Pedido não foi criado! verifique se o atendente existe.");
    System.out.println(e.getMessage());
    } finally {
    conexao.fechaConexao();
    }
    
    }*/
    
    

    /*public void atualizaPizza(Pedido pz) throws SQLException { /não está mais sendo usado,
            Conexao conexao = new Conexao();
            
            PreparedStatement st = null;
            
            try {
            String sql = "";
            sql += "";
            sql += "UPDATE pedido " //ATUALIZA PIZZA ONDE ID PIZZA FOR X
            + "SET status = ?, precoTotal = ?, idMesa = ? "
            + "WHERE idPedido = ?";
            
            //objeto de instrucao sql
            st = conexao.getConexao().prepareStatement(sql);
            
            //definindo a parametrizacao dos objetos a serem alterados no banco
            st.setString(1, pz.getStatus());
            st.setDouble(2, pz.getPrecoTotal());
            st.setInt(3, pz.getIdMesa());
            st.setInt(4, pz.getIdPedido());
            
            //Executa a atualizacao
            st.executeUpdate();
            
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            } finally {
            st.close();
            }
            }*/

    /*    public void deletarPorId(Integer id) throws SQLException {  //não está mais sendo usado,
    Conexao conexao = new Conexao();
    PreparedStatement st = null;
    
    try {
    String sql = "";
    sql += "DELETE FROM pedido "
    + "WHERE idPedido = ?";
    
    //Execução do objeto que representa a instrucao SQL
    st = conexao.getConexao().prepareStatement(sql);
    
    st.setInt(1, id);//parametrizar o placeholder "?"
    st.executeUpdate();
    
    } catch (SQLException e) {
    System.out.println(e.getMessage());
    } finally {
    st.close();
    }
    }*/

}
