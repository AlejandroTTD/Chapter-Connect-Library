public class Sistema {
    public String fichalibro;
    public String factura;

    public Sistema(String fichalibro, String factura) {
        this.fichalibro = fichalibro;
        this.factura = factura;
    }
    private void generarFactura(String codigoBarras){}
    private void enviarFactura(String correo, String factura){}
    private void procesarVenta(){}
    private void procesarCompra(){}
    private void procesarReembolso(){}
    private void validarCredenciales(String usuario, String contrasena){}
    private void validarCodigoBarras(String codigoBarras){}
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
