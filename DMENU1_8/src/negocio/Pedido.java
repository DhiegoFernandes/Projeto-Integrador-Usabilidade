
package negocio;

public class Pedido {


    private int idPedido;
    private String status;
    private double precoTotal;
    private int idMesa;

    public Pedido(){//construtor padrão
        
    }
    
    public Pedido(int idMesa){
        this.idMesa = idMesa;
    }

    public Pedido(int idPedido, String status, double precoTotal, int idMesa) {
        this.idPedido = idPedido;
        this.status = status;
        this.precoTotal = precoTotal;
        this.idMesa = idMesa;
    }

    //sets e gets dos atributos
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

}
