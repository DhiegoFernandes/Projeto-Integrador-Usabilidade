package conexao;

import negocio.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidosDAO {

    public List<Pedido> buscaPorPedido(int idPedido) throws SQLException {//obtem pizza pelo codigo do atendente

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
            stmt.setString(1, "%" + idPedido + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Pedido pz = new Pedido(); //Criando uma instância, novo carro na memória

                pz.setIdPedido(resultado.getInt("idPedido")); // Define ID do pedido;
                pz.setStatus(resultado.getString("status")); // Define status do pedido;
                pz.setPrecoTotal(resultado.getDouble("precoTotal")); // Define precoTotal do pedido;
                pz.setIdMesa(resultado.getInt("idMesa")); // Define ID do carro;

                // Insere o pedido na lista Local
                listaDePedidos.add(pz);
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
    
     public List<Pedido> ListaTodosOsPedidos() throws SQLException {//obtem pizza pelo codigo do atendente

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

                ped.setIdPedido(resultado.getInt("idPedido")); // Define ID do pedido;
                ped.setStatus(resultado.getString("status")); // Define status do pedido;
                ped.setPrecoTotal(resultado.getDouble("precoTotal")); // Define precoTotal do pedido;
                ped.setIdMesa(resultado.getInt("idMesa")); // Define ID da mesa;

                // Insere a pizza na lista Local
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

    public void InserePedido(Pedido pz) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO pedido"
                    + "(idPedido, status, precoTotal, idMesa)" //4 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?)"; //4 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, pz.getIdPedido());
            st.setString(2, pz.getStatus());
            st.setDouble(3, pz.getPrecoTotal());
            st.setInt(4, pz.getIdMesa());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    pz.setIdMesa(id);
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
    
     public void criaPedido(Pedido pz){

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
     
     public void adicionaCarrinho(Pedido pz){

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
    
    public void atualizaPizza(Pedido pz) throws SQLException {
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
    }

    public void deletarPorId(Integer id) throws SQLException {
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
    }
    
    
}
