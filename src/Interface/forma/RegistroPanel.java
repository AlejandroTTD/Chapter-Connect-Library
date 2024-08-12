package Interface.forma;

import javax.swing.*;
import Interface.Customer.newButton;
import java.awt.*;

public class RegistroPanel extends JPanel {
    private JTextField txtUsuario, txtEmail;
    private newButton btnNuevo, btnModificar, btnEliminar, btnGuardar, btnCancelar;
    private JList<String> listaUsuarios;
    private DefaultListModel<String> modeloLista;

    public RegistroPanel() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDatos.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField(20);
        panelDatos.add(txtUsuario);
        panelDatos.add(new JLabel("Email:"));
        txtEmail = new JTextField(20);
        panelDatos.add(txtEmail);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNuevo = new newButton("Nuevo");
        btnModificar = new newButton("Modificar");
        btnEliminar = new newButton("Eliminar");
        btnGuardar = new newButton("Guardar");
        btnCancelar = new newButton("Cancelar");
        panelBotones.add(btnNuevo);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        // Lista de usuarios
        modeloLista = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaUsuarios);

        // Añadir componentes al panel principal
        add(panelDatos, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Configurar acciones de los botones
        configurarAcciones();
    }

    private void configurarAcciones() {
        btnNuevo.addActionListener(e -> limpiarCampos());
        
        btnModificar.addActionListener(e -> {
        });
        
        btnEliminar.addActionListener(e -> {
        });
        
        btnGuardar.addActionListener(e -> {
        });
        
        btnCancelar.addActionListener(e -> limpiarCampos());
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtEmail.setText("");
    }
}