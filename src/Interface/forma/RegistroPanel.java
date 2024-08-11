package Interface.forma;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Interface.IAStyle;
import Interface.Customer.newButton;
import Interface.Customer.newLabel;
import Interface.Customer.newTexBox;

public class RegistroPanel extends JPanel{

    private newLabel          lblUsername,
                              lblPassword;
    private newTexBox         txtUsername;
    private JPasswordField    txpPassword;
    private newButton         btnREGISTRO;
    private newButton         btnMODIFICACION;
    private newButton         btnELIMINACION;

    public RegistroPanel() {
        initializeComponents();
        customizeComponent();
        btnREGISTRO.addActionListener(    e -> btnRegistroClick());
        btnMODIFICACION.addActionListener(e -> btnModificacionClick());
        btnELIMINACION.addActionListener( e -> btnEliminarClick());

    }

    private void customizeComponent() {
        setBackground(IAStyle.COLOR_FONDO2);
    }
    

    private void btnRegistroClick() {
        String username = txtUsername.getText();
        char[] password = txpPassword.getPassword();

        JOptionPane.showMessageDialog(RegistroPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        txtUsername.setText("");
        txpPassword.setText("");
    }

    private void btnModificacionClick() {
        String username = txtUsername.getText();
        char[] password = txpPassword.getPassword();

        JOptionPane.showMessageDialog(RegistroPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Modificacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        txtUsername.setText("");
        txpPassword.setText("");
    }

    private void btnEliminarClick() {
        String username = txtUsername.getText();
        char[] password = txpPassword.getPassword();

        JOptionPane.showMessageDialog(RegistroPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Eliminacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        txtUsername.setText("");
        txpPassword.setText("");
    }



    private void initializeComponents() {
        lblUsername        = new newLabel("Username:");
        lblPassword        = new newLabel("Password:");
        txtUsername        = new newTexBox();
        txpPassword        = new JPasswordField();
        btnREGISTRO        = new newButton("Registrar");
        btnMODIFICACION    = new newButton("Modificar");
        btnELIMINACION     = new newButton("Eliminar");
        

        //txtUsername.setBorder(txtUsername.createBorderLine());
        txtUsername.setBorderLine();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtUsername, gbc);

        // Etiqueta y campo de texto para la contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txpPassword, gbc);

        // Botón de login en la fila 2
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnREGISTRO, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnMODIFICACION, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnELIMINACION, gbc);

        
    }
}
