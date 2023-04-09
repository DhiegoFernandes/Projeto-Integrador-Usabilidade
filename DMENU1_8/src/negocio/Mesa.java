
package negocio;

public class Mesa {
    
    private int idMesa;

    public Mesa() {//construtor padrão
        
    }

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
    }

    //getters and setters
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }
    @Override
    public String toString() {
        return "Mesa " + idMesa;
    }
    
    
    
}
