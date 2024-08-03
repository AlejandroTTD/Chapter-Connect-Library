public abstract class Persona {
    private String correo;

    public Persona() {
        correo = "";
    }


    public void buscarLibro(String criterioBusqueda) {
        System.out.println("Consultando libro... ");
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
