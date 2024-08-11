package DataAccess.DTO;

public class EntidadTipoDTO {
    private Integer ID_EntidadTipo; 
    private String  Nombre;
    private String  Estado;        
    private String  FechaCreacion;
    private String  FechaModifica;

    public EntidadTipoDTO(){}
    public EntidadTipoDTO(Integer ID_EntidadTipo, String nombre, String estado, 
                           String fechaCreacion, String fechaModifica) {

        this.ID_EntidadTipo = ID_EntidadTipo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }
    public Integer getID_EntidadTipo() {
        return ID_EntidadTipo;
    }
    public void setID_EntidadTipo(Integer ID_EntidadTipo) {
        this.ID_EntidadTipo = ID_EntidadTipo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
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
            + "\n ID_EntidadTipo: "+getID_EntidadTipo()
            + "\n Nombre:         "+getNombre()
            + "\n Estado:         "+getEstado()
            + "\n FechaCreacion:  "+getFechaCreacion()
            + "\n FechaModifica:  "+getFechaModifica();
    }
}
