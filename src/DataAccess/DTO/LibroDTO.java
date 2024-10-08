package DataAccess.DTO;

public class LibroDTO {
    private Integer ID_Libro ;
    private Integer ID_Proveedor;
    private String titulo         ;
    private String autor;
    private String genero         ;
    private String editorial;
    private String anioPublicacion; 
    private Float precioVenta;
    private Float precioCompra;
    private String codigoBarra;
    private Integer nroUnidades   ; 
    private String Estado;
    private String FechaCreacion ; 
    private String FechaModifica;


    
    public LibroDTO(Integer iD_Libro, Integer iD_Proveedor, String titulo, String autor, String genero, String editorial,
            String anioPublicacion, Float precioVenta, Float precioCompra, String codigoBarra, Integer nroUnidades,
             String estado, String fechaCreacion, String fechaModifica) {
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
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public LibroDTO(){}

    public LibroDTO(String codigoB){
        this.codigoBarra = codigoB;
    }
    public LibroDTO(int idLibro, String titulo, String autor, String genero, String editorial, String anioPublicacionn,
            float precioVenta, String codigoBarrass) {
        this.ID_Libro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacionn;
        this.precioVenta = precioVenta;
        this.codigoBarra = codigoBarrass;
    }

    public Integer getID_Libro() {
        return ID_Libro;
    }
    public void setID_Libro(Integer iD_Libro) {
        ID_Libro = iD_Libro;
    }
    public Integer getID_Proveedor() {
        return ID_Proveedor;
    }
    public void setID_Proveedor(Integer iD_Proveedor) {
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
    public Float getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Float getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public Integer getNroUnidades() {
        return nroUnidades;
    }
    public void setNroUnidades(Integer nroUnidades) {
        this.nroUnidades = nroUnidades;
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
                + "\n Estado:            " + getEstado()
                + "\n FechaCreacion:     " + getFechaCreacion()
                + "\n FechaModifica:     " + getFechaModifica();
    }
}
