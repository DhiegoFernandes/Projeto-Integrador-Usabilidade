package negocio;

public class Mesa {

    private int idmesa;
    private String status;

    public Mesa() {//construtor padrão

    }

    //getters and setters
    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mesa " + idmesa;
    }

}
