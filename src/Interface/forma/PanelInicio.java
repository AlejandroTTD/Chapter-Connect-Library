package Interface.forma;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Interface.IAStyle;

public class PanelInicio extends JPanel{
public PanelInicio(){
        customizeComponent();
    }

    private void customizeComponent() {
        setBackground(IAStyle.COLOR_FONDO2);
        setPreferredSize(new Dimension(180, 820)); 

        try {
            ImageIcon imageIcon = new ImageIcon(IAStyle.URL_FONDO);
            add(new JLabel(imageIcon),BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
