public class Cliente extends Persona {
    private String correo;
    
    public void realizarCompra() {}
    public void buscarLibro() {}
    public void realizarDevolucion() {}
        
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
