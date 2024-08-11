package Interface.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interface.IAStyle;

public class newLabel extends JLabel {
    public newLabel(){
        customizeComponent();
    }
    public newLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), IAStyle.FONT_BOLD, IAStyle.COLOR_FONT_LIGHT, IAStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}
