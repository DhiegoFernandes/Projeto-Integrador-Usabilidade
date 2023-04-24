package negocio;

public class Pedido {

    private int idpedido;
    private int fk_pedido_mesa;
    private double total;
    private String data;
    private String status;

    public Pedido() {//construtor padrão

    }

    public Pedido(int idpedido, int fk_pedido_mesa, double total, String data, String status) {
        this.idpedido = idpedido;
        this.fk_pedido_mesa = fk_pedido_mesa;
        this.total = total;
        this.data = data;
        this.status = status;
    }

    //sets e gets dos atributos
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getFk_pedido_mesa() {
        return fk_pedido_mesa;
    }

    public void setFk_pedido_mesa(int fk_pedido_mesa) {
        this.fk_pedido_mesa = fk_pedido_mesa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
