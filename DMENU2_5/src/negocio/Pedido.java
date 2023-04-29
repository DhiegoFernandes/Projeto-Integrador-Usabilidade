package negocio;

public class Pedido {

    private int idpedido;
    private int id_mesa;
    private double total;
    private String data;
    private String status;

    public Pedido() {//construtor padrão

    }

    public Pedido(int idpedido, int id_mesa, double total, String data, String status) {
        this.idpedido = idpedido;
        this.id_mesa = id_mesa;
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

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
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
