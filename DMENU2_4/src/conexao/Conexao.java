package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String statusConexao = "Não conectado!";

    public Connection getConexao() {

        Connection conexao = null;

        try {
            //define o driver de conexao para a conexao
            String nomeDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(nomeDriver);//classe do driver a ser utilizada

            String servidor = "localhost";//servidor
            String schema = "digitalmenu";//banco de dados

            String url = "jdbc:mysql://" + servidor + "/" + schema;

            String usuario = "senacsp";
            String senha = "123456";

            //String de conexao
            conexao = (Connection) DriverManager.getConnection(url, usuario, senha);

            if (conexao != null) {
                statusConexao = "Conectado";
            } else {
                statusConexao = "Não conectado!";
            }
            //retorna a conexao pra principal/ ou quando der getConexao
            return conexao;

        } catch (ClassNotFoundException e) {//se o driver de conexao nao for encontrado
            System.out.println("Driver de conexão não encontrado!");
            return null;
        } catch (SQLException e) {
            System.out.println("Falha da conexão!");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String getStatusConexao(){
        return statusConexao;
    }
    
    public boolean fechaConexao(){
        try {
            getConexao().close();//fecha a conexao
            statusConexao = "Conexão Fechada";
            return true;
        } catch (SQLException e) {//se der erro imprime
            System.out.println(e.getMessage());
            return false;
        }
    }
    //metodo para reiniciar a conexao, se necessario
    public Connection reiniciaConexao(){
        fechaConexao();//fecha conexao
        return getConexao();//abre conexao
    }
}
