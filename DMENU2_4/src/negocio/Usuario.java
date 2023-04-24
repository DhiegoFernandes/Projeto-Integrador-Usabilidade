
package negocio;

public class Usuario {
    
    private int idusuario;
    private String usuario;
    private String senha;
    private String tipoacesso;
    private String status;


    public Usuario() {//construtor padrao
        
    }

    public Usuario(String usuario, String senha, String tipoacesso, String status) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoacesso = tipoacesso;
        this.status = status;
    }
    
    //getters and setters
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoacesso() {
        return tipoacesso;
    }

    public void setTipoacesso(String tipoacesso) {
        this.tipoacesso = tipoacesso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  
    
    
}
