package Interface.forma;

import javax.swing.*;
import Interface.Customer.newButton;
import java.awt.*;

public class InventarioPanel extends JPanel {
    private JTextField txtTituloLibro, txtAutor, txtEditorial, txtAnyo, txtPrecio, txtCodBarras; 
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
        panelDatos.add(new JLabel("Autor:"));
        txtAutor = new JTextField(50);
        panelDatos.add(txtAutor);
        panelDatos.add(new JLabel("Editorial:"));
        txtEditorial = new JTextField(50);
        panelDatos.add(txtEditorial);
        panelDatos.add(new JLabel("Año:"));
        txtAnyo = new JTextField(50);
        panelDatos.add(txtAnyo);
        panelDatos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField(50);
        panelDatos.add(txtPrecio);
        panelDatos.add(new JLabel("CodBarras:"));
        txtCodBarras = new JTextField(50);
        panelDatos.add(txtCodBarras);
        
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
        
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
        });
        
        btnCancelar.addActionListener(e -> cancelarVenta());
    }


    private void cancelarVenta() {
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro de cancelar?", "Confirmar cancelacion",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpiarCampos();
        }
    }
    private void limpiarCampos() {
        txtTituloLibro.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtAnyo.setText("");
        txtPrecio.setText("");
        txtCodBarras.setText("");
    }
}

