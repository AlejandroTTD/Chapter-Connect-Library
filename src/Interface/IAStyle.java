package Interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class IAStyle {
    public static final Color COLOR_FONT = new Color(0, 34, 141); //(218, 8, 40)
    public static final Color COLOR_FONT_LIGHT = new Color(85, 85, 85);
    public static final Color COLOR_FONDO  = Color.red;
    public static final Color COLOR_CURSOR = Color.red;
    public static final Color COLOR_BORDER = Color.black;
    public static final Font  FONT         = new Font("Bold", Font.PLAIN, 20);
    public static final Font  FONT_BOLD    = new Font("Bold", Font.BOLD | Font.PLAIN, 20);
    public static final Font  FONT_SMALL   = new Font("Bold", Font.PLAIN| Font.PLAIN, 10);
    
    public static final int ALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_MAIN  = IAStyle.class.getResource("/Interface/Image/inicio.png.png");
    public static final URL URL_LOGO  = IAStyle.class.getResource("/Interface/Image/logo.png.png");
    public static final URL URL_FONDO  = IAStyle.class.getResource("/Interface/Image/libreria.png");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.BLACK),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "😏 CCLibrary", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 CCLibrary", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "😞 CCLibrary", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
