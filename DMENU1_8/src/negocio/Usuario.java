
package negocio;

public class Usuario {
    
    private String usuario;
    private String acesso;
    private String senha;
    private int idUsuario;

    public Usuario() {//construtor padrao
        
    }

    public Usuario(String usuario, String acesso, String senha) {
        this.usuario = usuario;
        this.acesso = acesso;
        this.senha = senha;
    }
    
    //getters and setters
      public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
