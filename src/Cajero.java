public class Cajero extends Persona {
    private String usuario;
    private String clave;
    private String correo;


    public Cajero(){
        usuario     = "";
        clave       = "";
        correo      = "";
    }

    public Cajero(String usuario, String clave) {
        setUsuario(usuario);
        setClave(clave);
        setCorreo(correo);
    }

    public void ingresaCompra() {}
    public void ingresaVenta() {}
    public void ingresaDevolucion() {}
    public void consultarStock(/*String, String, String, String*/) {
        System.out.println("Consultando stock... ");
    }
    public void iniciarSesion(/*String, String */) {}
    public void cerrarSesion() {}
    public void modificarBD() {}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario != null)
            this.usuario = usuario.toUpperCase();
        else
            this.usuario = "";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        if (clave != null)
            this.clave = clave.toUpperCase();
        else
            this.clave = "";
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
 
}
