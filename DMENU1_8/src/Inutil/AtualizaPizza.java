
package Inutil;

import conexao.PedidosDAO;
import java.sql.SQLException;
import negocio.Pedido;
import java.util.Scanner;

public class AtualizaPizza {

    public void atualizarPizza() {
        
        try {
            Scanner sc = new Scanner(System.in);
            Pedido pizza = new Pedido();
            
            System.out.println("\n--- Atualiza status do pagamento ---");
            
            System.out.println("\nInforme o numPedido da a ser alterado: ");
            int numPedido = sc.nextInt();
            
            PedidosDAO pz = new PedidosDAO();
            
            //fazendo a chamada do metodo para buscar por id
            pz.buscaPorID(numPedido, pizza);
            
            System.out.println("Informe o novo status do pagamento");
            sc.nextLine();
            String statusPagamento = sc.nextLine(); //VER ERRO DE NEXT OU NEXTLINE
            
            pizza.setStatusPagamento(statusPagamento);//alterando obj, operam apenas o sabor
            pz.atualizaPizza(pizza);//chama o metodo de atualizacao
            
            System.out.println("Sabor atualizado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
