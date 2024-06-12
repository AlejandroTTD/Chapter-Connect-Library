public class Persona {
    private String correo;
    private String cedula;
    private String nombre;
    private String apellido;

    public Persona() {
        correo = "";
        cedula = "";
        nombre = "";
        apellido = "";
    }

    public Persona(String cedula, String nombre, String apellido) {
        setCedula(cedula);
        setNombre(nombre);
        setApellido(apellido);
    }

    public void consultarStock(/*String, String, String, String*/) {
        System.out.println("Consultando stock... ");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null)
            this.correo = "No valido";
        else
            this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula == null || cedula.length() != 10)
            this.cedula = "No valido";
        else
            this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null)
            this.nombre = nombre.toUpperCase();
        else
            this.nombre = "";
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null)
            this.apellido = apellido.toUpperCase();
        else
            this.apellido = "";
    }

}
