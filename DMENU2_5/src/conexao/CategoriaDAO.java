
package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Categoria;

public class CategoriaDAO {
    
    public List<Categoria> listaTodasAsCategorias() throws SQLException {

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de produtos para retornar
        List<Categoria> ListaDeCategorias = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de carros
            String sql = "select * from categoria;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            //stmt.setString(1, "%" + codAtendente + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Categoria cat = new Categoria(); //Criando uma instância, nova mesa na memória

                cat.setIdcategoria(resultado.getInt("idcategoria")); // Define ID da mesa
                cat.setNome(resultado.getString("nome"));
                cat.setStatus(resultado.getString("status"));   
                
                // Insere a categoria na lista Local
                ListaDeCategorias.add(cat);
            }

            // Retorna a lista de carros
            return ListaDeCategorias;
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
    
    public void insereCategoria(Categoria cat) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO categoria"
                    + "(idcategoria, nome, status)" //3 VALORES
                    + "VALUES"
                    + "(?, ?, ?)"; //3 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, cat.getIdcategoria());
            st.setString(2, cat.getNome());
            st.setString(3, cat.getStatus());
            
            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    cat.setIdcategoria(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Categoria não foi criada!");
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    }
    
    public void deletarPorId(Integer idcategoria) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "DELETE FROM categoria "
                    + "WHERE idcategoria = ?";

            //Execução do objeto que representa a instrucao SQL
            st = conexao.getConexao().prepareStatement(sql);

            st.setInt(1, idcategoria);//parametrizar o placeholder "?"
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }
    }
    
    public Categoria buscaPorID(int id, Categoria cat) {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from categoria "
                    + "WHERE idcategoria = ?";

            //define query sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            st.setInt(1, id);
            rs = st.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

                cat.setIdcategoria(rs.getInt("idcategoria"));
                cat.setNome(rs.getString("nome"));
                cat.setStatus(rs.getString("status"));

                return cat;
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
        return null;
    }
    
     public void atualizaMesa(Categoria cat) throws SQLException {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        try {
            String sql = "";
            sql += "";
            sql += "UPDATE categoria " //ATUALIZA mesa ONDE idmesa FOR X
                    + "SET nome = ?, status = ? "
                    + "WHERE idcategoria = ?";

            //objeto de instrucao sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo a parametrizacao dos objetos a serem alterados no banco
            st.setString(1, cat.getNome());
            st.setString(2, cat.getStatus());
            st.setInt(3, cat.getIdcategoria());

            //Executa a atualizacao
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }

    }

}
