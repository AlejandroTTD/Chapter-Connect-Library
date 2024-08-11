package DataAccess.DTO;

public class ClienteDTO {
    
    private Integer ID_Cliente ;
    private String Estado;
    private String FechaCreacion; 
    private String FechaModifica;

    public ClienteDTO(Integer iD_Cliente, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cliente = iD_Cliente;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    
    public ClienteDTO(){}

    public Integer getID_Cliente() {
        return ID_Cliente;
    }
    public void setID_Cliente(Integer iD_Cliente) {
        ID_Cliente = iD_Cliente;
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
                + "\n ID_Cliente:     " + getID_Cliente()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
