package negocio;

public class Categoria {

    private int idcategoria;
    private String nome;

    public Categoria() {//construtor padrao

    }

    public Categoria(int idcategoria, String nome) {
        this.idcategoria = idcategoria;
        this.nome = nome;
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

    @Override
    public String toString() {//TO STRING PARA CONTORNAR O HASHCODE, RETORNA A CATEGORIA EM STRING
        return nome;
    }

    
}
