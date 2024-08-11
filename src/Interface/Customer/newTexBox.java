package Interface.Customer;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Interface.IAStyle;

public class newTexBox extends JTextField{

    public newTexBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(IAStyle.FONT);  
        setForeground(IAStyle.COLOR_FONT_LIGHT);  
        setCaretColor(IAStyle.COLOR_CURSOR);    // Color del cursor
        setMargin(new Insets(10, 5, 5, 5));      // Ajusta los márgenes
        setOpaque(false);                       // Fondo transparente
        //setUI(new BasicTextFieldUI());  // Para deshabilitar el subrayado por defecto
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(IAStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, IAStyle.COLOR_BORDER) 
        ));
    }
}
