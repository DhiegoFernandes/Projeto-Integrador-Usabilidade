
package Inutil;

import conexao.PedidosDAO;
import negocio.Pedido;
import java.util.Scanner;

public class InserePizza {
    
    public void InserePizza(){//insere dados na tabela carro
        
        try {
            Scanner sc = new Scanner(System.in);
            Pedido ped = new Pedido();
            
            System.out.println("\n--- Insira os dados da pizza ---");
            
            System.out.print("\nInforme o Sabor: ");
            String sabor = sc.nextLine();
            System.out.print("\nInforme o Tamanho: ");
            String tamanho = sc.nextLine().toUpperCase();
            System.out.print("Informe o Preço: ");
            double valor = sc.nextDouble();
            
            //MANDA OS DADOS PARA A CLASSE PIZZA
            ped.setSabor(sabor); 
            ped.setTamanho(tamanho);
            ped.setValor(valor);
            
            PedidosDAO pD = new PedidosDAO();
            pD.InserePizza(ped);//INSERE DADOS DA PIZZA NA TABELA USANDO A CLASSE InserePizza
            System.out.println("\nPizza inserida com sucesso!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
