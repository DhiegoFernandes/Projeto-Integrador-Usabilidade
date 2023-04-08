package conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Produto;

public class ProdutosDAO {

    public List<Produto> ListaTodosOsProdutos() throws SQLException {//obtem pizza pelo codigo do atendente

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

                prod.setId(resultado.getInt("id")); // Define ID do produto;
                prod.setNome(resultado.getString("nome")); // Define nome do produto;
                prod.setPreco(resultado.getDouble("preco")); // Define preco do produto;
                prod.setDescricao(resultado.getString("descricao")); // Define descricao do produto;
                prod.setCategoria(resultado.getString("categoria")); // Define categoria do produto;

                // Insere a pizza na lista Local
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

    public void InsereProduto(Produto prod) {

        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "";
            sql += "INSERT INTO produto"
                    + "(id, nome, preco, descricao, categoria)" //5 VALORES
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)"; //5 INTERROGAÇOES

            st = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            st.setInt(1, prod.getId());
            st.setString(2, prod.getNome());
            st.setDouble(3, prod.getPreco());
            st.setString(4, prod.getDescricao());
            st.setString(5, prod.getCategoria());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    prod.setId(id);
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

    public void deletarPorId(Integer id) throws SQLException {
        Conexao conexao = new Conexao();
        PreparedStatement st = null;

        try {
            String sql = "";
            sql += "DELETE FROM produto "
                    + "WHERE id = ?";

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
