package negocio;

public class Atendente {

    private int codAtendente;
    private String nomeAtendente;
    private double salarioAtendente;

    //Construtor padrão
    public Atendente() {
        //Faça o que quiser na classe
    }

    // Construtor com argumentos - Siga as entradas dos argumentos
    // Lembre-se como criar: vide tópico 1X
    public Atendente(int codAtendente, String nomeAtendente, double salarioAtendente) {
        this.codAtendente = codAtendente;
        this.nomeAtendente = nomeAtendente;
        this.salarioAtendente = salarioAtendente;

    }

    public int getCodAtendente() {
        return codAtendente;
    }

    public void setCodAtendente(int codAtendente) {
        this.codAtendente = codAtendente;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public double getSalarioAtendente() {
        return salarioAtendente;
    }

    public void setSalarioAtendente(double salarioAtendente) {
        this.salarioAtendente = salarioAtendente;
    }

    // Alocação dos métodos hashCode e equals
    // Veja como inserir automaticamente no tópico 3X abaixo
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codAtendente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atendente other = (Atendente) obj;
        return this.codAtendente == other.codAtendente;
    }
    // Inserção do método toString
    // Veja como inserir automaticamente no tópico 4X

    @Override
    public String toString() {
        return this.getNomeAtendente();
        //return "Atendente{" + "nomeAtendente=" + nomeAtendente + '}';
    }

}
