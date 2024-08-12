package Interface.forma;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interface.IAStyle;
import Interface.Customer.newButton;

public class RegistroPanel extends JPanel{
    public newButton

        btnNuevoRegistro         = new newButton("Nuevo"),
        btnModificarRegistro     = new newButton("Modificar"),
        btnEliminatr             = new newButton("Eliminar");

    public RegistroPanel(){
        customizeComponent();
    }

    private void customizeComponent() {
        setBackground(IAStyle.COLOR_FONDO2);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(180, 820)); 

        try {
            ImageIcon imageIcon = new ImageIcon(IAStyle.URL_FONDO);
            add(new JLabel(imageIcon),BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add(btnNuevoRegistro);
        add(btnModificarRegistro);
        add(btnEliminatr);
    }

}