package DataAccess.DTO;

public class ProveedorDTO {
    private Integer ID_Proveedor ;
    private Integer ID_EntidadTipo;
    private String Nombre        ;
    private String Estado        ;
    private String FechaCreacion ;
    private String FechaModifica;

    public ProveedorDTO(Integer iD_Proveedor, Integer iD_EntidadTipo, String nombre, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Proveedor = iD_Proveedor;
        ID_EntidadTipo = iD_EntidadTipo;
        Nombre = nombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public ProveedorDTO(){}

    public Integer getID_Proveedor() {
        return ID_Proveedor;
    }
    public void setID_Proveedor(Integer iD_Proveedor) {
        ID_Proveedor = iD_Proveedor;
    }
    public Integer getID_EntidadTipo() {
        return ID_EntidadTipo;
    }
    public void setID_EntidadTipo(Integer iD_EntidadTipo) {
        ID_EntidadTipo = iD_EntidadTipo;
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
                + "\n ID_Proveedor:   " + getID_Proveedor()
                + "\n ID_EntidadTipo: " + getID_EntidadTipo()
                + "\n Nombre:         " + getNombre()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
