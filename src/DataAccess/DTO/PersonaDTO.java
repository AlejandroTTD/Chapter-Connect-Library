package DataAccess.DTO;

public class PersonaDTO {
    private Integer ID_Persona; 
    private Integer ID_EntidadTipo;
    private String  Nombre        ;
    private String  Apellido;
    private String  Direccion;     
    private String  Telefono;
    private String  Email   ;
    private String  Estado;
    private String  FechaCreacion; 
    private String  FechaModifica;

    public PersonaDTO(Integer iD_Persona, Integer iD_EntidadTipo, String nombre, String apellido, String direccion,
            String telefono, String email, String estado, String fechaCreacion, String fechaModifica) {
        ID_Persona = iD_Persona;
        ID_EntidadTipo = iD_EntidadTipo;
        Nombre = nombre;
        Apellido = apellido;
        Direccion = direccion;
        Telefono = telefono;
        Email = email;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public PersonaDTO(){}

    public Integer getID_Persona() {
        return ID_Persona;
    }
    public void setID_Persona(Integer iD_Persona) {
        ID_Persona = iD_Persona;
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
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
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
                + "\n ID_Persona:     " + getID_Persona()
                + "\n ID_EntidadTipo: " + getID_EntidadTipo()
                + "\n Nombre:         " + getNombre()
                + "\n Apellido:       " + getApellido()
                + "\n Direccion:      " + getDireccion()
                + "\n Telefono:       " + getTelefono()
                + "\n Email:          " + getEmail()
                + "\n Estado:         " + getEstado()
                + "\n FechaCreacion:  " + getFechaCreacion()
                + "\n FechaModifica:  " + getFechaModifica();
    }
}
