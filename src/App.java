import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Cliente      c = new Cliente();
        Cajero      ca = new Cajero();

        System.out.println(c.getCedula());
        System.out.println(c.getNombre());
        System.out.println(c.getApellido());

        System.out.println(ca.getCedula());
        System.out.println(ca.getNombre());
        System.out.println(ca.getApellido());    
    }
}
