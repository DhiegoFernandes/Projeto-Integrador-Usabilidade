package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Usuario;

public class UsuariosDAO {

    public List<Usuario> ListaTodosOsUsuarios() throws SQLException {//obtem pizza pelo codigo do atendente

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de produtos para retornar
        List<Usuario> listaDeUsuarios = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de usuario
            String sql = "select * from usuario;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            //stmt.setString(1, "%" + codAtendente + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Usuario user = new Usuario(); //Criando uma instância, novo usuario na memória

                user.setIdUsuario(resultado.getInt("idUsuario")); // Define login do usuario
                user.setUsuario(resultado.getString("usuario")); // Define login do usuario
                user.setAcesso(resultado.getString("acesso")); // Define acesso do usuario
                user.setSenha(resultado.getString("senha")); // Define senha do usuario

                // Insere a pizza na lista Local
                listaDeUsuarios.add(user);
            }

            // Retorna a lista de carros
            return listaDeUsuarios;
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

    public void InsereUsuario(Usuario user) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO usuario"
                    + "(idUsuario, usuario, acesso, senha)" //4 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?)"; //4 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, user.getIdUsuario());
            st.setString(2, user.getUsuario());
            st.setString(3, user.getAcesso());
            st.setString(4, user.getSenha());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setIdUsuario(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário não foi criado!");
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    }

    public void deletarPorId(Integer id) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "DELETE FROM usuario "
                    + "WHERE idUsuario = ?";

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

    public boolean checkLogin(String usuario, String senha) throws SQLException {//obtem pizza pelo codigo do atendente

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        boolean check = false;

        try {
            // Comando SQL na base = tabela de usuario
            String sql = "select * from usuario WHERE usuario = ? AND senha = ?;";//###

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
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
