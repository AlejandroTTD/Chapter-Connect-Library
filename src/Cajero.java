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

    private void ingresaCompra() {}
    private void ingresaVenta() {}
    private void ingresaDevolucion() {}
    public void buscarLibro(String criterioBusqueda) {
        System.out.println("Consultando stock... ");
    }
    private void iniciarSesion(String usuario, String passw) {}
    private void cerrarSesion() {}
    private void modificarBD() {}

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
