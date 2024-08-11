package Interface.forma;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.IOException;
import java.awt.*;

import javax.swing.BoxLayout;

import Interface.IAStyle;
import Interface.Customer.newButton2;
import Interface.Customer.newLabelText;

public class PanelBotones extends JPanel{
    public newButton2
        btnHOME         = new newButton2("Home"),
        btnREGISTRO     = new newButton2("Registro"),
        btnVENTAS       = new newButton2("Ventas"),
        btnCOMPRAS      = new newButton2("Compras"),
        btnINVENTARIO   = new newButton2("Inventario"),
        btnFACTURACION  = new newButton2("Facturacion"),
        btnEXIT         = new newButton2("Exit");

    public PanelBotones(){
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight())); 

        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(btnHOME);
        add(btnREGISTRO);
        add(btnVENTAS);
        add(btnCOMPRAS);
        add(btnINVENTARIO);
        add(btnFACTURACION);
        add(btnEXIT);

        add(new newLabelText("\u00A9 2024 Chapter Connect"));
    }
}
