package Interface.Customer;

import Interface.IAStyle;

import javax.swing.*;

import java.awt.*;

public class newLabelText extends JPanel{
    private newLabel    lblEtiq = new newLabel();
    private newTexBox  txtCont= new newTexBox();

    public newLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiq.setCustomizeComponent(  etiqueta, 
                                            IAStyle.FONT_SMALL, 
                                            IAStyle.COLOR_FONT_LIGHT, 
                                            IAStyle.ALIGNMENT_LEFT); 
        txtCont.setBorderLine();
        add(lblEtiq, BorderLayout.NORTH);
        add(txtCont, BorderLayout.CENTER);
    }
}
