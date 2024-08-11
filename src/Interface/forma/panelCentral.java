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
        pnlApart.btnREGISTRO.addActionListener(null);
        pnlApart.btnVENTAS.addActionListener(null);
        pnlApart.btnCOMPRAS.addActionListener(null);
        pnlApart.btnINVENTARIO.addActionListener(null);
        pnlApart.btnFACTURACION.addActionListener(null);
    }

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(1050, 500);
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
