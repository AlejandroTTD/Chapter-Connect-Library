package DataAccess.DTO;

public class ClienteDTO {
    
    private Integer ID_Cliente ;
    private Integer ID_Persona;
    private String Fecha_Registro;
    private String Estado;
    private String FechaCreacion; 
    private String FechaModifica;

    public ClienteDTO(Integer iD_Cliente, Integer iD_Persona, String fecha_Registro, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cliente = iD_Cliente;
        ID_Persona = iD_Persona;
        Fecha_Registro = fecha_Registro;
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
    public Integer getID_Persona() {
        return ID_Persona;
    }
    public void setID_Persona(Integer iD_Persona) {
        ID_Persona = iD_Persona;
    }
    public String getFecha_Registro() {
        return Fecha_Registro;
    }
    public void setFecha_Registro(String fecha_Registro) {
        Fecha_Registro = fecha_Registro;
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
                + "\n ID_Persona:     " + getID_Persona()
                + "\n Fecha_Registro: " + getFecha_Registro()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
