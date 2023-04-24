package Inutil;

import conexao.PedidosDAO;
import java.sql.SQLException;
import negocio.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ListagemPizzas {

    public void listaTodasPizzas() throws SQLException {

//instancia pizzasDao
        PedidosDAO pizza = new PedidosDAO();

//Gera a lista de pizzas localmente, que sera preenchida
        List<Pedido> listaDePizzas;
        listaDePizzas = new ArrayList<>();

//pega (Obtem) a lista de pizzas atraves do atendente
        listaDePizzas = pizza.listaTodosOsPedidos();

//Inicia a impressao dos dados dos pizzas do banco
        System.out.println("Pedido\t|\t Valor\t|\tMesa\t|  Atendente\t|\tStatus\t");
        System.out.println("----\t|\t -----\t|     -----\t|\t----\t|");

        for (Pedido pizzaLocal : listaDePizzas) { //Iterador para cada carro na lista de carros
            System.out.print(pizzaLocal.getNumPedido()+ "\t|\t");
            System.out.print(pizzaLocal.getPrecoTotal()+ "\t|\t");
            System.out.print(pizzaLocal.getMesa()+ "\t|\t");
            System.out.print(pizzaLocal.getFk_Atendente_codAtendente()+ "\t|\t");
            System.out.print(pizzaLocal.getStatusPagamento()+ "\t|\t");
            System.out.print("\n");

        }

    }

}
