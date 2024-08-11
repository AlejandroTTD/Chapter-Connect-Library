package Interface.forma;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainForma extends JFrame{

    PanelLogin   pnLg         = new PanelLogin();
    LoginUs      pnLongi      = new LoginUs();
    panelCentral pnlPanCent   = new panelCentral("Inicio");

    
    public MainForma(String tilteApp) {
    customizeComponent(tilteApp);
        pnLg.btnLogin.addActionListener(   e -> setPanel(new LoginUs()));
        pnLg.btnExit.addActionListener(    e -> System.exit(0));
        pnLongi.btnEnter.addActionListener(e -> setPanel2(new panelCentral(tilteApp)));
            
    }
    
    private void setPanel(LoginUs loginUs) {
        Container container = getContentPane();
        container.removeAll();
        container.add(pnLongi, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void setPanel2(panelCentral panelCentral) {
        Container container = getContentPane();
        container.removeAll();
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
        container.add(pnLg, BorderLayout.CENTER);
        setVisible(true);
    }


}

