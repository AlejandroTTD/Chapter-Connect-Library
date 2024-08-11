package Interface.Customer;

import javax.swing.ImageIcon;

import Interface.IAStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class newLabelLink extends newLabel implements MouseListener{
    newLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    newLabelLink(String text, String iconnew){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconnew));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(IAStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(IAStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(IAStyle.CURSOR_DEFAULT);
    }
}
