package negocio;

public class Produto {

    private int idproduto;
    private String nome;
    private double preco;
    private String descricao;
    private int id_categoria;
    private String status;

    public Produto() {//construtor padrão

    }

    public Produto(int idproduto, String nome, double preco, String descricao, int id_categoria, String status) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.id_categoria = id_categoria;
        this.status = status;
    }

    

    //getters and setters
    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
