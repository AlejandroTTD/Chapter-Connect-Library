package Framework;

public class PatException extends Exception {

    public PatException(String e, String clase, String metodo) {
        // grabar el log
        System.out.println("[ERROR APP --> LOG] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage() {
        return "Lo sentimos, ha ocurrido un error inesperado D:..";
    }
}