package DataAccess.DTO;

public class ClienteDTO {
    
    private Integer ID_Cliente ;
    private Integer ID_EntidadTipo;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Estado;
    private String FechaCreacion; 
    private String FechaModifica;

    public ClienteDTO(Integer iD_Cliente,Integer iD_EntidadTipo, String nombre, String apellido, String email, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Cliente = iD_Cliente;
        ID_EntidadTipo = iD_EntidadTipo;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    
    public ClienteDTO(Integer iD_EntidadTipo, String nombre,String apellido, String email) {
        this.ID_EntidadTipo = iD_EntidadTipo;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Email = email;
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
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n ID_Cliente:     " + getID_Cliente()
                + "\n ID_EntidadTipo: " + getID_EntidadTipo()
                + "\n Nombre:         " + getNombre()
                + "\n Apellido:       " + getApellido()
                + "\n Email:          " + getEmail()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }

}
