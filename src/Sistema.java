public class Sistema {
    public String fichalibro;
    public String factura;

    public Sistema(String fichalibro, String factura) {
        this.fichalibro = fichalibro;
        this.factura = factura;
    }
    private void generarFactura(String codigoBarras){}
    public void enviarFactura(String correo, String factura){}
    private void procesarVenta(){}
    private void procesarCompra(){}
    public void procesarReembolso(){}
    public boolean validarCredenciales(String usuario, String contrasena){}
    public String getFichalibro() {
        return fichalibro;
    }
    public void setFichalibro(String fichalibro) {
        this.fichalibro = fichalibro;
    }
    public String getFactura() {
        return factura;
    }
    public void setFactura(String factura) {
        this.factura = factura;
    }
}
