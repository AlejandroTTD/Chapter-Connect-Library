package DataAccess.DTO;

public class Detalle_VentaDTO {
    private Integer ID_Detalle_Venta ;
    private Integer ID_Cajero;
    private Integer ID_Cliente     ; 
    private Integer ID_Libro;
    private String FechaVenta    ;  
    private Integer Cantidad;
    private Float PrecioUnitario; 
    private Float Total;
    private String Estado        ;  
    private String FechaCreacion ;
    private String FechaModifica;

    public Detalle_VentaDTO(Integer iD_Detalle_Venta, Integer iD_Cajero, Integer iD_Cliente, Integer iD_Libro,
            String fechaVenta, Integer cantidad, Float precioUnitario, Float total, String estado,
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

    public Detalle_VentaDTO(Object iD_Detalle_Venta2, int idCajero, int iD_Cliente2, Integer id_Libro2, String format,
            Integer nroUnidades, Float precioVenta, double total2, String estado2, String format2,
            Object fechaModifica2) {
        this.ID_Detalle_Venta = (iD_Detalle_Venta2 instanceof Integer) ? (Integer) iD_Detalle_Venta2 : null;
        this.ID_Cajero = idCajero;
        this.ID_Cliente = iD_Cliente2;
        this.ID_Libro = id_Libro2;
        this.FechaVenta = format;
        this.Cantidad = nroUnidades;
        this.PrecioUnitario = precioVenta;
        this.Total = (float) total2;
        this.Estado = estado2;
        this.FechaCreacion = format2;
        this.FechaModifica = (fechaModifica2 instanceof String) ? (String) fechaModifica2 : null;
    }

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
    public Integer getCantidad() {
        return Cantidad;
    }
    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }
    public Float getPrecioUnitario() {
        return PrecioUnitario;
    }
    public void setPrecioUnitario(Float precioUnitario) {
        PrecioUnitario = precioUnitario;
    }
    public Float getTotal() {
        return Total;
    }
    public void setTotal(Float total) {
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
