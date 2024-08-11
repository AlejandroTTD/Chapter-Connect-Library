package Interface.forma;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class PanelPagSig extends JFrame {
    LoginUs pnLongi      = new LoginUs();
    panelCentral pnlPanCent = new panelCentral("Inicio");

    public PanelPagSig(String tilteApp) {
        customizeComponent(tilteApp);
            pnLongi.btnEnter.addActionListener(e -> setPanel(new panelCentral(tilteApp)));
            
        }
    
        private void setPanel(panelCentral panelCentral) {
            Container container = getContentPane();
            container.remove(pnLongi);
            container.add(pnlPanCent, BorderLayout.CENTER);
            revalidate();
            repaint();
        }

        private void customizeComponent(String tilteApp) {
            setTitle(tilteApp);
                setSize(360, 415);
                setResizable(false);
                setLocationRelativeTo(null); // Centrar en la pantalla
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                Container container = getContentPane();
                container.setLayout(new BorderLayout());
                
                // Agregar los paneles al contenedor
                container.add(pnLongi, BorderLayout.CENTER);
                setVisible(true);
        }
        
        
}
