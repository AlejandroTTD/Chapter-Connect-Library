package DataAccess.DTO;

public class CajeroDTO {
    private Integer ID_Cajero  ;  
    private String Usuario ;
    private String Contrasena;
    private String Estado     ;  
    private String FechaCreacion; 
    private String FechaModifica;

    
    public CajeroDTO(Integer iD_Cajero, String usuario, String contrasena, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cajero = iD_Cajero;
        Usuario = usuario;
        Contrasena = contrasena;
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
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
    public String getContrasena() {
        return Contrasena;
    }
    public void setContrasena(String contrasena) {
        contrasena = Contrasena;
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
                + "\n Usuario:        " + getUsuario()
                + "\n Contrasena:     " + getContrasena()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
