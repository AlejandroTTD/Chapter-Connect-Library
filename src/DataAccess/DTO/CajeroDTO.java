package DataAccess.DTO;

public class CajeroDTO {
    private Integer ID_Cajero  ;  
    private Integer ID_Persona;
    private String Usuario ;
    private String Password;
    private String Estado     ;  
    private String FechaCreacion; 
    private String FechaModifica;

    
    public CajeroDTO(Integer iD_Cajero, Integer iD_Persona, String usuario, String password, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cajero = iD_Cajero;
        ID_Persona = iD_Persona;
        Usuario = usuario;
        Password = password;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public CajeroDTO(){}

    public Integer getID_Cajero() {
        return ID_Cajero;
    }
    public void setID_Cajero(Integer iD_Cajero) {
        ID_Cajero = iD_Cajero;
    }
    public Integer getID_Persona() {
        return ID_Persona;
    }
    public void setID_Persona(Integer iD_Persona) {
        ID_Persona = iD_Persona;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n ID_Cajero:      " + getID_Cajero()
                + "\n ID_Persona:     " + getID_Persona()
                + "\n Usuario:        " + getUsuario()
                + "\n Password:       " + getPassword()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
