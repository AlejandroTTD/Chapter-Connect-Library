import java.sql.Connection;

import DataAccess.EntidadTipoDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.EntidadTipoDTO;
import Interface.forma.MainForma;
import Interface.forma.cambioPanel;

public class App {
    public static void main(String[] args) throws Exception {
        cambioPanel.show();
        MainForma frmMain = new MainForma("Libreria");
        frmMain.setVisible(true);
    }
}
