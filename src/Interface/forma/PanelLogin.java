package Interface.forma;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

import Interface.IAStyle;
import Interface.Customer.newButton;

public class PanelLogin extends JPanel{
    public newButton
        btnLogin    = new newButton("Login"),
        btnExit     = new newButton("Exit");

    public PanelLogin(){
        customizeComponent();
    }

    private void customizeComponent() {
        setPreferredSize(new Dimension(500, getHeight())); 

        
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(350, 310, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(btnLogin);
        add(btnExit);
        
    }

    }

