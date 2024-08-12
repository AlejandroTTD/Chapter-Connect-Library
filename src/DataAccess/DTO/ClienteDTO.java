package DataAccess.DTO;

public class ClienteDTO {
    
    private Integer ID_Cliente ;
    private Integer ID_EntidadTipo;
    private String Estado;
    private String FechaCreacion; 
    private String FechaModifica;

    public ClienteDTO(Integer iD_Cliente,Integer iD_EntidadTipo, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cliente = iD_Cliente;
        ID_EntidadTipo = iD_EntidadTipo;
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
    public Integer getID_EntidadTipo() {
        return ID_EntidadTipo;
    }

    public void setID_EntidadTipo(Integer iD_EntidadTipo) {
        ID_EntidadTipo = iD_EntidadTipo;
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
                + "\n ID_EntidadTipo: " + getID_EntidadTipo()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }

}
