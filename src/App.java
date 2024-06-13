import java.util.Scanner;

import BaseDatos.Libro;

public class App {
    public static Scanner sc = new Scanner(System.in);
    //Codigo para implementar en interfaz
    private static final int MAX_LIBROS = 100;
    private static Libro[] libros = new Libro[MAX_LIBROS];
    private static int contadorLibros = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "password";

    public static void main(String[] args) {
        if (autenticarUsuario()) {
            boolean salir = false;

            while (!salir) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (opcion) {
                    case 1:
                        registrarCompra();
                        break;
                    case 2:
                        registrarVenta();
                        break;
                    case 3:
                        mostrarLibros();
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Autenticación fallida. Programa terminado.");
        }
    }

    private static boolean autenticarUsuario() {
        System.out.print("Ingrese usuario: ");
        String usuarioIngresado = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasenaIngresada = scanner.nextLine();

        return USUARIO.equals(usuarioIngresado) && CONTRASENA.equals(contrasenaIngresada);
    }

    private static void mostrarMenu() {
        System.out.println("Menú de la Biblioteca");
        System.out.println("1. Registrar compra de un libro");
        System.out.println("2. Registrar venta de un libro");
        System.out.println("3. Mostrar todos los libros");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarCompra() {
        if (contadorLibros < MAX_LIBROS) {
            System.out.print("Ingrese el título del libro: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el autor del libro: ");
            String autor = scanner.nextLine();
            System.out.print("Ingrese el año de publicación: ");
            int anioPublicacion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            System.out.print("Ingrese el género del libro: ");
            String genero = scanner.nextLine();
            System.out.print("Ingrese el precio de venta: ");
            float precioVenta = scanner.nextFloat();
            System.out.print("Ingrese el precio de compra: ");
            float precioCompra = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline
            System.out.print("Ingrese el número de unidades: ");
            int nroUnidades = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            String codigoBarra = generarCodigoDeBarras(titulo, autor);

            Libro nuevoLibro = new Libro(titulo, autor, anioPublicacion, genero, precioVenta, precioCompra, codigoBarra, nroUnidades);
            libros[contadorLibros] = nuevoLibro;
            contadorLibros++;
            System.out.println("Libro comprado y registrado exitosamente.");
        } else {
            System.out.println("No se pueden registrar más libros. Capacidad máxima alcanzada.");
        }
    }

    private static void registrarVenta() {
        System.out.print("Ingrese el título del libro a vender: ");
        String titulo = scanner.nextLine();
        boolean libroEncontrado = false;

        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = true;
                System.out.print("Ingrese el correo del cliente: ");
                String correoCliente = scanner.nextLine();
                generarFactura(libros[i], correoCliente);
                // Eliminar el libro del arreglo
                for (int j = i; j < contadorLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                libros[--contadorLibros] = null;
                System.out.println("Libro vendido y eliminado del registro.");
                break;
            }
        }

        if (!libroEncontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void mostrarLibros() {
        if (contadorLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (int i = 0; i < contadorLibros; i++) {
                System.out.println(libros[i]);
            }
        }
    }

    private static String generarCodigoDeBarras(String titulo, String autor) {
        // Generación simple de un código de barras
        return "CB-" + titulo.hashCode() + "-" + autor.hashCode();
    }

    private static void generarFactura(Libro libro, String correoCliente) {
        // Simulación de generación y envío de factura
        System.out.println("Generando factura para: " + libro.getTitulo());
        System.out.println("Enviando factura al correo: " + correoCliente);
    }
}
