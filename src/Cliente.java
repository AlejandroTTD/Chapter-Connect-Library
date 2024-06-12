public class Cliente extends Persona {
    public String metodoPago;
    private String correo;
    
    public void realizarCompra() {}
    public void buscarLibro() {}
    public void realizarDevolucion() {}
    public void consultarStock(/*String, String, String, String */) {}
    
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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
