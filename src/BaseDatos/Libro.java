package BaseDatos;
public class Libro{
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private float precioVenta;
    private float precioCompra;
    public String codigoBarra;
    public int nroUnidades;

    public Libro(String titulo2, String autor2, int anioPublicacion2, String genero2, float precioVenta2,
            float precioCompra2, String codigoBarra2, int nroUnidades2) {
    }
    private void actualizarPrecio(){}
    private void actualizarStock(){
        nroUnidades = nroUnidades - 1;
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
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public float getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    public float getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public int getNroUnidades() {
        return nroUnidades;
    }
    public void setNroUnidades(int nroUnidades) {
        this.nroUnidades = nroUnidades;
    }



}
