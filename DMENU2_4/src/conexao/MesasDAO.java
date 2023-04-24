package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Mesa;

public class MesasDAO {

    public List<Mesa> listaTodasAsMesas() throws SQLException {

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de produtos para retornar
        List<Mesa> ListaDeMesas = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de carros
            String sql = "select * from mesa;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            //stmt.setString(1, "%" + codAtendente + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Mesa mesa = new Mesa(); //Criando uma instância, nova mesa na memória

                mesa.setIdmesa(resultado.getInt("idMesa")); // Define ID da mesa
                mesa.setStatus(resultado.getString("status"));

                // Insere a pizza na lista Local
                ListaDeMesas.add(mesa);
            }

            // Retorna a lista de carros
            return ListaDeMesas;
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

    public void insereMesa(Mesa mesa) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO mesa"
                    + "(idmesa, status)" //2 VALORES
                    + "VALUES"
                    + "(?, ?)"; //2 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, mesa.getIdmesa());
            st.setString(2, mesa.getStatus());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    mesa.setIdmesa(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mesa não foi criada!");
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    }

    public void deletarPorId(Integer idMesa) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "DELETE FROM mesa "
                    + "WHERE idMesa = ?";

            //Execução do objeto que representa a instrucao SQL
            st = conexao.getConexao().prepareStatement(sql);

            st.setInt(1, idMesa);//parametrizar o placeholder "?"
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }
    }

    public Mesa buscaPorID(int id, Mesa mesa) {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from mesa "
                    + "WHERE idmesa = ?";

            //define query sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            st.setInt(1, id);
            rs = st.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

                mesa.setIdmesa(rs.getInt("idmesa"));
                mesa.setStatus(rs.getString("status"));

                return mesa;
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
        return null;
    }

    public void atualizaMesa(Mesa mesa) throws SQLException {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        try {
            String sql = "";
            sql += "";
            sql += "UPDATE mesa " //ATUALIZA mesa ONDE idmesa FOR X
                    + "SET status = ?"
                    + "WHERE idmesa = ?";

            //objeto de instrucao sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo a parametrizacao dos objetos a serem alterados no banco
            st.setString(1, mesa.getStatus());
            st.setInt(2, mesa.getIdmesa());

            //Executa a atualizacao
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }

    }

    public boolean checkMesa(int idMesa) throws SQLException {//obtem mesa pelo id da mesa

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        boolean check = false;

        try {
            // Comando SQL na base = tabela de usuario
            String sql = "select * from mesa WHERE idMesa = ?;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            stmt.setInt(1, idMesa);

            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...      
            if (resultado.next()) {
                check = true;
            }

        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return false;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            resultado.close();
            stmt.close();
            con.getConexao().close();
        }
        return check;
    }

}
