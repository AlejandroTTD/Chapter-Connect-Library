import java.util.Scanner;

public class LectorBarra {
    public static Scanner scBarra = new Scanner(System.in);
    public String codigoBarra;
    public String producto;

    public void leerCodigoBarra(String codigoBarra){}
    public void verificarCodigoBarra(String codigoBarra){}

    public static Scanner getScBarra() {
        return scBarra;
    }
    public static void setScBarra(Scanner scBarra) {
        LectorBarra.scBarra = scBarra;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
}
