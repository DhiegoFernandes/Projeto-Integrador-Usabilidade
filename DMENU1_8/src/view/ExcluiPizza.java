package view;

import conexao.PedidosDAO;
import java.sql.SQLException;
import java.util.Scanner;


public class ExcluiPizza {

    public void excluirPizza() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n--- EXCLUI DADOS DA PIZZA ---");
            System.out.print("\nInforme o ID da Pizza a ser excluído");
            int id = sc.nextInt();
            
            PedidosDAO pz = new PedidosDAO();
            
            //fazendo a chamada do metodo para excluir carro pelo seu ID
            pz.deletarPorId(id);
            
            //Mensagem de retorno ao usuario
            System.out.println("\nPizza excluído com sucesso!\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

}
