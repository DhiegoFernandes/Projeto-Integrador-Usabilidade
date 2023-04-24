
package conexao;


import negocio.Atendente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendentesDAO {
    
    // Método para retornar lista de carros, como todos os carros
    public List<Atendente> listaAtendentes() throws SQLException{
        //Conecta ao banco de dados por meio da classe de conexão
        Conexao con = new Conexao();
        con.getConexao(); //Obtendo a conexão
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //Prepara a lista de carros para retornar
            List<Atendente> listaDeAtendentes = new ArrayList<>();
            
            // Comando SQL na base = tabela de atendentes
            String sql = "select * from tb_atendente;";

            //Executa a query (comando SQL)
            stmt = con.getConexao().prepareStatement(sql);
            rs = stmt.executeQuery();

            //Para cada item retornado no comando (SQL) faça...
            while (rs.next()) {
                Atendente at = new Atendente(); //Criando uma instância, novo carro na memória

                at.setCodAtendente(rs.getInt("codAtendente"));
                at.setNomeAtendente(rs.getString("nomeAtendente"));
                at.setSalarioAtendente(rs.getDouble("salarioAtendente"));

                // Insere o revenda na lista Local
                listaDeAtendentes.add(at);
            }

            // Retorna a lista de carros
            return listaDeAtendentes;
        } catch (SQLException e) { //Caso dê alguma exceção
            System.out.println(e.getMessage());
            return null;
        } finally {
            // Após terminar, fecha a conexão, stmt, rs
            rs.close();
            stmt.close();
            con.getConexao().close();
        }
    }

}

