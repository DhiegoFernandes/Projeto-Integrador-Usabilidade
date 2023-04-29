 package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Usuario;

public class UsuariosDAO {

    public List<Usuario> listaTodosOsUsuarios() throws SQLException {

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

                user.setIdusuario(resultado.getInt("idusuario")); // Define id do usuario
                user.setUsuario(resultado.getString("usuario")); // Define login do usuario
                user.setSenha(resultado.getString("senha")); // Define senha do usuario               
                user.setTipoacesso(resultado.getString("tipoacesso"));
                user.setStatus(resultado.getString("status"));

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

    public void insereUsuario(Usuario user) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO usuario"
                    + "(idusuario, usuario, senha, tipoacesso, status)" //5 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)"; //4 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, user.getIdusuario());
            st.setString(2, user.getUsuario());
            st.setString(3, user.getSenha());
            st.setString(4, user.getTipoacesso());
            st.setString(5, user.getStatus());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    user.setIdusuario(id);
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

    public List<Usuario> buscaPorUsuario(String usuario) throws SQLException {//obtem pizza pelo codigo do atendente

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de carros para retornar
        List<Usuario> ListaDeUsuarios = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de usuarios
            String sql = "select * from usuario WHERE usuario LIKE ?;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + usuario + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Usuario user = new Usuario(); //Criando uma instância, novo usuario na memória

                user.setIdusuario(resultado.getInt("idusuario"));
                user.setUsuario(resultado.getString("usuario"));
                user.setSenha(resultado.getString("senha"));
                user.setTipoacesso(resultado.getString("tipoacesso"));
                user.setStatus(resultado.getString("status"));

                // Insere o usuario na lista Local
                ListaDeUsuarios.add(user);
            }

            // Retorna a lista de usuarios
            return ListaDeUsuarios;
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

    public Usuario buscaPorID(int idusuario, Usuario user) {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from usuario "
                    + "WHERE idusuario = ?";

            //define query sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            st.setInt(1, idusuario);
            rs = st.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

                user.setIdusuario(rs.getInt("idusuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                user.setTipoacesso(rs.getString("tipoacesso"));
                user.setStatus(rs.getString("status"));

                return user;
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
        return null;
    }

    public void atualizaUsuario(Usuario user) throws SQLException {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        try {
            String sql = "";
            sql += "";
            sql += "UPDATE usuario " //ATUALIZA PIZZA ONDE ID PIZZA FOR X
                    + "SET usuario = ?, senha = ?, tipoacesso = ?, status = ? "
                    + "WHERE idusuario = ?";

            //objeto de instrucao sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo a parametrizacao dos objetos a serem alterados no banco
            
            st.setString(1, user.getUsuario());
            st.setString(2, user.getSenha());
            st.setString(3, user.getTipoacesso());
            st.setString(4, user.getStatus());
            st.setInt(5, user.getIdusuario());

            //Executa a atualizacao
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }

    }
    
    /*    public void deletarPorId(Integer id) throws SQLException { //não está sendo utilizado mais, agora usa o desativar por id
    Conexao conexao = new Conexao();
    PreparedStatement st = null;
    
    try {
    String sql = "";
    sql += "DELETE FROM usuario "
    + "WHERE idusuario = ?";
    
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
