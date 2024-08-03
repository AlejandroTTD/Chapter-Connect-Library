import java.util.Scanner;

public class LectorBarra {
    public static Scanner scBarra = new Scanner(System.in);
    public String codigoBarra;
    public void leerCodigoBarra(String codigoBarras){}

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
}
