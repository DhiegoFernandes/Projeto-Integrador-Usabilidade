package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Produto;

public class ProdutosDAO {

    public List<Produto> listaTodosOsProdutos() throws SQLException {//obtem todos os produtos

        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet resultado = null;

        //Prepara a lista de produtos para retornar
        List<Produto> listaDeProdutos = new ArrayList<>();

        try {
            // Comando SQL na base = tabela de carros
            String sql = "select * from produto;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            //stmt.setString(1, "%" + codAtendente + "%");
            resultado = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (resultado.next()) {
                Produto prod = new Produto(); //Criando uma instância, novo produto na memória

                prod.setIdproduto(resultado.getInt("idproduto")); // Define ID do produto;
                prod.setNome(resultado.getString("nome")); // Define nome do produto;
                prod.setPreco(resultado.getDouble("preco")); // Define preco do produto;
                prod.setDescricao(resultado.getString("descricao")); // Define descricao do produto;
                prod.setId_categoria(resultado.getInt("id_categoria")); // Define categoria do produto;
                prod.setStatus(resultado.getString("status")); // Define status

                // Insere a produto na lista Local
                listaDeProdutos.add(prod);
            }

            // Retorna a lista de carros
            return listaDeProdutos;
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

    public void insereProduto(Produto prod) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO produto"
                    + "(idproduto, nome, preco, descricao, id_categoria, status)" //6 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?)"; //6 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, prod.getIdproduto());
            st.setString(2, prod.getNome());
            st.setDouble(3, prod.getPreco());
            st.setString(4, prod.getDescricao());
            st.setInt(5, prod.getId_categoria());
            st.setString(6, prod.getStatus());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    prod.setIdproduto(id);
                }
                rs.close();
            } else {
                throw new SQLException("Erro inesperado! Nenhuma linha afetada!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não foi criado!");
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }

    }

    public void deletarPorId(Integer idproduto) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "DELETE FROM produto "
                    + "WHERE id = ?";

            //Execução do objeto que representa a instrucao SQL
            st = conexao.getConexao().prepareStatement(sql);

            st.setInt(1, idproduto);//parametrizar o placeholder "?"
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }
    }
    
    public Produto buscaPorID(int idproduto, Produto prod) {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "";
            sql += "";
            sql += "SELECT * from produto "
                    + "WHERE idproduto = ?";

            //define query sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo o que foi recuperado da query, neste caso o id
            st.setInt(1, idproduto);
            rs = st.executeQuery();//Retorna os dados em modo de tabela

            if (rs.next()) { //testa se veio algum resultado

                prod.setIdproduto(rs.getInt("idproduto"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setId_categoria(rs.getInt("id_categoria"));
                prod.setStatus(rs.getString("status"));

                return prod;
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conexao.fechaConexao();
        }
        return null;
    }
    
     public void atualizaProduto(Produto prod) throws SQLException {
        Conexao conexao = new Conexao();

        PreparedStatement st = null;
        try {
            String sql = "";
            sql += "";
            sql += "UPDATE produto " //ATUALIZA produto ONDE idproduto FOR X
                    + "SET nome = ?, preco = ?, descricao = ?, id_categoria = ?, status = ?"
                    + "WHERE idproduto = ?";

            //objeto de instrucao sql
            st = conexao.getConexao().prepareStatement(sql);

            //definindo a parametrizacao dos objetos a serem alterados no banco
            st.setString(1, prod.getNome());
            st.setDouble(2, prod.getPreco());
            st.setString(3, prod.getDescricao());
            st.setInt(4, prod.getId_categoria());
            st.setString(5, prod.getStatus());
            st.setInt(6, prod.getIdproduto());

            //Executa a atualizacao
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            st.close();
        }

    }
}
