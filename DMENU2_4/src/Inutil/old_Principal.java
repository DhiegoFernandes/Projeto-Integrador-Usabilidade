
package view;

import Inutil.ExcluiPizza;
import Inutil.AtualizaPizza;
import Inutil.InserePizza;
import Inutil.ListagemPizzas;
import conexao.Conexao;
import java.sql.SQLException;
import java.util.Scanner;

public class old_Principal {
    public static void main(String[] args) throws SQLException {    

        /*        Conexao cn = new Conexao();
        cn.getConexao();//pega a conexao com o driver
        System.out.println("O status da conexao é: " + cn.getStatusConexao());*/ 
        
        Scanner sc = new Scanner(System.in);
        
        ListagemPizzas lstPizzas = new ListagemPizzas();//lista pizzas
        InserePizza insPizzas = new InserePizza();//insere pizzas
        AtualizaPizza atualiPizza = new AtualizaPizza();
        ExcluiPizza excluiPizza = new ExcluiPizza();
        
        
        int op = 0;
        while (op != 5){
            System.out.println("\t ---- MENU ----");
            System.out.println("\t1. Listar");
            System.out.println("\t2. Inserir");
            System.out.println("\t3. Atualizar");
            System.out.println("\t4. Excluir");
            System.out.println("\t5. Sair");
            System.out.println("\tEscolha uma opção: ");
            op = sc.nextInt();
            
            if (op == 5){
                break;
            }
            
            switch (op) {
                case 1:
                    lstPizzas.listaTodasPizzas();
                    break;
                    
                case 2:
                    insPizzas.InserePizza();
                    break;
                case 3:
                    atualiPizza.atualizarPizza();
                    break;
                case 4:
                    excluiPizza.excluirPizza();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n\t -- Opção inválida -- \n");
            }
        }
        
    }
    
}
