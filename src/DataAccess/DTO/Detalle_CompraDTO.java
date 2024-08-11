package DataAccess.DTO;

public class Detalle_CompraDTO {
    private Integer ID_Detalle_Compra ;
    private Integer ID_Proveedor;
    private Integer ID_Libro       ;  
    private String Cantidad;
    private String PrecioUnitario ;  
    private String Total;
    private String FechaCompra    ;  
    private String Estado ;
    private String FechaCreacion ;
    private String FechaModifica;

    public Detalle_CompraDTO(Integer iD_Detalle_Compra, Integer iD_Proveedor, Integer iD_Libro, String cantidad,
            String precioUnitario, String total, String fechaCompra, String estado, String fechaCreacion,
            String fechaModifica) {
        ID_Detalle_Compra = iD_Detalle_Compra;
        ID_Proveedor = iD_Proveedor;
        ID_Libro = iD_Libro;
        Cantidad = cantidad;
        PrecioUnitario = precioUnitario;
        Total = total;
        FechaCompra = fechaCompra;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Detalle_CompraDTO(){}

    public Integer getID_Detalle_Compra() {
        return ID_Detalle_Compra;
    }
    public void setID_Detalle_Compra(Integer iD_Detalle_Compra) {
        ID_Detalle_Compra = iD_Detalle_Compra;
    }
    public Integer getID_Proveedor() {
        return ID_Proveedor;
    }
    public void setID_Proveedor(Integer iD_Proveedor) {
        ID_Proveedor = iD_Proveedor;
    }
    public Integer getID_Libro() {
        return ID_Libro;
    }
    public void setID_Libro(Integer iD_Libro) {
        ID_Libro = iD_Libro;
    }
    public String getCantidad() {
        return Cantidad;
    }
    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }
    public String getPrecioUnitario() {
        return PrecioUnitario;
    }
    public void setPrecioUnitario(String precioUnitario) {
        PrecioUnitario = precioUnitario;
    }
    public String getTotal() {
        return Total;
    }
    public void setTotal(String total) {
        Total = total;
    }
    public String getFechaCompra() {
        return FechaCompra;
    }
    public void setFechaCompra(String fechaCompra) {
        FechaCompra = fechaCompra;
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
                + "\n ID_DetalleCompra:      " + getID_Detalle_Compra()
                + "\n ID_Proveedor:          " + getID_Proveedor()
                + "\n ID_Libro:              " + getID_Libro()
                + "\n Cantidad:              " + getCantidad()
                + "\n PrecioUnitario:        " + getPrecioUnitario()
                + "\n Total:                 " + getTotal()
                + "\n FechaCompra:           " + getFechaCompra()
                + "\n Estado:                " + getEstado()
                + "\n FechaCreacion:         " + getFechaCreacion()
                + "\n FechaModifica:         " + getFechaModifica();
    }
}
