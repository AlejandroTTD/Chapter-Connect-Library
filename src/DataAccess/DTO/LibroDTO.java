package DataAccess.DTO;

public class LibroDTO {
    private String ID_Libro ;
    private String ID_Proveedor;
    private String titulo         ;
    private String autor;
    private String genero         ;
    private String editorial;
    private String anioPublicacion; 
    private String precioVenta;
    private String precioCompra   ;
    private String codigoBarra;
    private String nroUnidades   ; 
    private String FechaEntrega;
    private String Estado;
    private String FechaCreacion ; 
    private String FechaModifica;


    
    public LibroDTO(String iD_Libro, String iD_Proveedor, String titulo, String autor, String genero, String editorial,
            String anioPublicacion, String precioVenta, String precioCompra, String codigoBarra, String nroUnidades,
            String fechaEntrega, String estado, String fechaCreacion, String fechaModifica) {
        ID_Libro = iD_Libro;
        ID_Proveedor = iD_Proveedor;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.codigoBarra = codigoBarra;
        this.nroUnidades = nroUnidades;
        FechaEntrega = fechaEntrega;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public LibroDTO(){}

    public String getID_Libro() {
        return ID_Libro;
    }
    public void setID_Libro(String iD_Libro) {
        ID_Libro = iD_Libro;
    }
    public String getID_Proveedor() {
        return ID_Proveedor;
    }
    public void setID_Proveedor(String iD_Proveedor) {
        ID_Proveedor = iD_Proveedor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public String getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }
    public String getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public String getNroUnidades() {
        return nroUnidades;
    }
    public void setNroUnidades(String nroUnidades) {
        this.nroUnidades = nroUnidades;
    }
    public String getFechaEntrega() {
        return FechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        FechaEntrega = fechaEntrega;
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
                + "\n ID_Libro:          " + getID_Libro()
                + "\n ID_Proveedor:      " + getID_Proveedor()
                + "\n Titulo:            " + getTitulo()
                + "\n Genero:            " + getGenero()
                + "\n Editorial:         " + getEditorial()
                + "\n Anyo:              " + getAnioPublicacion()
                + "\n PrecioVenta:       " + getPrecioVenta()
                + "\n PrecioCompra:      " + getPrecioCompra()
                + "\n CodigoBarras:      " + getCodigoBarra()
                + "\n NroUnidades:       " + getNroUnidades()
                + "\n FechaEntrega:      " + getFechaEntrega()
                + "\n Estado:            " + getEstado()
                + "\n FechaCreacion:     " + getFechaCreacion()
                + "\n FechaModifica:     " + getFechaModifica();
    }
}
