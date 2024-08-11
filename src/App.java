import DataAccess.EntidadTipoDAO;
import DataAccess.DTO.EntidadTipoDTO;
import Interface.forma.MainForma;
import Interface.forma.cambioPanel;

public class App {
    public static void main(String[] args) throws Exception {
        cambioPanel.show();
        MainForma frmMain = new MainForma("Libreria");
        frmMain.setVisible(true);

        // try {
        // EntidadTipoDAO eTDao = new EntidadTipoDAO();
        // for (EntidadTipoDTO eT : eTDao.readAll())
        // System.out.println(eT.toString());
        // } catch (Exception e) {
        // System.out.println(e.toString());
        // }
    }
}
