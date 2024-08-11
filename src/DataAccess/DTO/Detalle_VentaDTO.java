package DataAccess.DTO;

public class Detalle_VentaDTO {
    private Integer ID_Detalle_Venta ;
    private Integer ID_Cajero;
    private Integer ID_Cliente     ; 
    private Integer ID_Libro;
    private String FechaVenta    ;  
    private String Cantidad;
    private String PrecioUnitario; 
    private String Total;
    private String Estado        ;  
    private String FechaCreacion ;
    private String FechaModifica;

    public Detalle_VentaDTO(Integer iD_Detalle_Venta, Integer iD_Cajero, Integer iD_Cliente, Integer iD_Libro,
            String fechaVenta, String cantidad, String precioUnitario, String total, String estado,
            String fechaCreacion, String fechaModifica) {
        ID_Detalle_Venta = iD_Detalle_Venta;
        ID_Cajero = iD_Cajero;
        ID_Cliente = iD_Cliente;
        ID_Libro = iD_Libro;
        FechaVenta = fechaVenta;
        Cantidad = cantidad;
        PrecioUnitario = precioUnitario;
        Total = total;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Detalle_VentaDTO(){}

    public Integer getID_Detalle_Venta() {
        return ID_Detalle_Venta;
    }
    public void setID_Detalle_Venta(Integer iD_Detalle_Venta) {
        ID_Detalle_Venta = iD_Detalle_Venta;
    }
    public Integer getID_Cajero() {
        return ID_Cajero;
    }
    public void setID_Cajero(Integer iD_Cajero) {
        ID_Cajero = iD_Cajero;
    }
    public Integer getID_Cliente() {
        return ID_Cliente;
    }
    public void setID_Cliente(Integer iD_Cliente) {
        ID_Cliente = iD_Cliente;
    }
    public Integer getID_Libro() {
        return ID_Libro;
    }
    public void setID_Libro(Integer iD_Libro) {
        ID_Libro = iD_Libro;
    }
    public String getFechaVenta() {
        return FechaVenta;
    }
    public void setFechaVenta(String fechaVenta) {
        FechaVenta = fechaVenta;
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
                + "\n ID_DetalleVenta:      " + getID_Detalle_Venta()
                + "\n ID_Cajero:            " + getID_Cajero()
                + "\n ID_Cliente:           " + getID_Cliente()
                + "\n ID_Libro:             " + getID_Libro()
                + "\n FechaVenta:           " + getFechaVenta()
                + "\n Cantidad:             " + getCantidad()
                + "\n PrecioUnitario:       " + getPrecioUnitario()
                + "\n Total:                " + getTotal()
                + "\n Estado:               " + getEstado()
                + "\n FechaCreacion:        " + getFechaCreacion()
                + "\n FechaModifica:        " + getFechaModifica();
    }
}
