package Interface.Customer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import Interface.IAStyle;

import java.awt.event.MouseListener;

public class newButton extends JButton implements MouseListener {
    public newButton(String text){
        customizeComponent(text);
    }
    public newButton(String text, String iconnew){
        customizeComponent(text, iconnew);
    }

    public void customizeComponent(String text, String iconnew){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 100, 20); 
        
        setIcon(new ImageIcon(iconnew));
        setFont(IAStyle.FONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(true);
        setContentAreaFilled(false);
        setForeground(IAStyle.COLOR_FONT);
        setHorizontalAlignment(IAStyle.ALIGNMENT_CENTER);
        setFont(IAStyle.FONT); 
        //setBackground(IAStyle.COLOR_BORDER);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        setForeground(Color.BLACK);
        setCursor(IAStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(IAStyle.CURSOR_DEFAULT);
    }
}
