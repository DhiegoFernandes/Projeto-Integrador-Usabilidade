package negocio;

public class Categoria {

    private int idcategoria;
    private String nome;
    private String status;

    public Categoria() {//construtor padrao

    }

    public Categoria(int idcategoria, String nome, String status) {
        this.idcategoria = idcategoria;
        this.nome = nome;
        this.status = status;
    }

    //getters and setters
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {//TO STRING PARA CONTORNAR O HASHCODE, RETORNA A CATEGORIA EM STRING
        return nome;
    }

    
}
