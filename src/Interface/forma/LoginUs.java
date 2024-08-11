package Interface.forma;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Interface.Customer.newButton;
import Interface.Customer.newLabel;
import Interface.Customer.newTexBox;

public class LoginUs extends JPanel{
    private newLabel        lblUsername,
                            lblPassword;
    private newTexBox       txtUsername;
    private JPasswordField  txpPassword;
    
    
    public newButton
    btnEnter    = new newButton("Enter");
    
    public LoginUs() {
        customizeComponent();
        initializeComponents();
    }
    private void initializeComponents() {
        lblUsername = new newLabel("Username:");
        lblPassword = new newLabel("Password:");
        txtUsername = new newTexBox();
        txpPassword = new JPasswordField();
        
        txtUsername.setBorderLine();
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtUsername, gbc);
        
        //Etiqueta y campo de texto para la contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txpPassword, gbc);
        
        //Botón de login en la fila 2
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnEnter, gbc);
        
    }    
    
    private void customizeComponent() {
        setPreferredSize(new Dimension(500, getHeight())); 
        add(btnEnter);
        
    }
        
}    
        
