import Interface.forma.MainForma;
import Interface.forma.cambioPanel;

public class Aplicacion {
    public static void main(String[] args) {
        cambioPanel.show();
        MainForma frmMain = new MainForma("Libreria");
            frmMain.setVisible(true);
    }
}
