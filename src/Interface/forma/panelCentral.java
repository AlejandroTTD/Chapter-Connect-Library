package Interface.forma;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelCentral extends JFrame{
    PanelBotones pnlApart = new PanelBotones();
    JPanel       pnlInicio = new PanelInicio();

    public panelCentral(String tilteApp) {
        customizeComponent(tilteApp);
        pnlApart.btnHOME.addActionListener(         e -> setPanel(new PanelInicio()));
        pnlApart.btnREGISTRO.addActionListener(     e -> setPanel(new RegistroPanel()));
        pnlApart.btnVENTAS.addActionListener(       e -> setPanel(new VentasPanel()));
        pnlApart.btnCOMPRAS.addActionListener(      e -> setPanel(new ComprasPanel()));
        pnlApart.btnINVENTARIO.addActionListener(   e -> setPanel(new InventarioPanel()));
        pnlApart.btnFACTURACION.addActionListener(  e -> setPanel(new FacturacionPanel()));
        pnlApart.btnEXIT.addActionListener(         e -> System.exit(0));
    }

    private void setPanel(JPanel formPanel) {
        Container container = getContentPane();
        container.remove(pnlInicio);
        pnlInicio = formPanel;
        container.add(pnlInicio, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(1545, 820);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlApart, BorderLayout.WEST);
        container.add(pnlInicio, BorderLayout.CENTER);
        setVisible(true);
    }   
}
