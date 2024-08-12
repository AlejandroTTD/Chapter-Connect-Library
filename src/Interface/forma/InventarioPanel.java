package Interface.forma;

import javax.swing.*;
import Interface.Customer.newButton;
import java.awt.*;

public class InventarioPanel extends JPanel {
    private JTextField txtTituloLibro, txtAutor, txtCodBarras; 
    private newButton btnNuevo, btnModificar, btnEliminar, btnGuardar, btnCancelar;
    private JList<String> listaTituloLibros;
    private DefaultListModel<String> modeloLista;

    public InventarioPanel() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDatos.add(new JLabel("TituloLibro:"));
        txtTituloLibro = new JTextField(50);
        panelDatos.add(txtTituloLibro);
        panelDatos.add(new JLabel("CodBarras:"));
        txtCodBarras = new JTextField(50);
        panelDatos.add(txtCodBarras);
        panelDatos.add(new JLabel("Autor:"));
        txtAutor = new JTextField(50);
        panelDatos.add(txtAutor);

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

        // Lista de TituloLibros
        modeloLista = new DefaultListModel<>();
        listaTituloLibros = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaTituloLibros);

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
        txtTituloLibro.setText("");
        txtAutor.setText("");
    }
}

