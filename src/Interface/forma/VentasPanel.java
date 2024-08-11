package Interface.forma;

import javax.swing.*;
import java.awt.*;
import Interface.Customer.newButton;
import Interface.Customer.newButton2;

public class VentasPanel extends JPanel {
    private newButton btnConsumidorFinal, btnConFactura;
    private JTextField txtCodigoBarras;
    private JList<String> listaProductos;
    private DefaultListModel<String> modeloLista;
    private JTextField txtCantidad;
    private JLabel lblTotal;
    private newButton2 btnAgregar, btnEliminar, btnConfirmar, btnCancelar;

    public VentasPanel() {
        setLayout(new BorderLayout());

        // Panel superior para selección de cliente
        JPanel panelCliente = new JPanel();
        btnConsumidorFinal = new newButton("Consumidor Final");
        btnConFactura = new newButton("Con Factura");
        panelCliente.add(btnConsumidorFinal);
        panelCliente.add(btnConFactura);
        add(panelCliente, BorderLayout.NORTH);

        // Panel central para productos y codigo de barras
        JPanel panelCentral = new JPanel(new BorderLayout());

        // Panel código de barras
        JPanel panelCodigoBarras = new JPanel();
        panelCodigoBarras.add(new JLabel("Código de Barras:"));
        txtCodigoBarras = new JTextField(15);
        panelCodigoBarras.add(txtCodigoBarras);
        panelCentral.add(panelCodigoBarras, BorderLayout.NORTH);

        // Lista productos
        modeloLista = new DefaultListModel<>();
        listaProductos = new JList<>(modeloLista);
        JScrollPane scrollProductos = new JScrollPane(listaProductos);
        panelCentral.add(scrollProductos, BorderLayout.CENTER);

        // Panel para cantidad y botones de agregar/eliminar
        JPanel panelAcciones = new JPanel();
        panelAcciones.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField(5);
        panelAcciones.add(txtCantidad);
        btnAgregar = new newButton2("Agregar");
        btnEliminar = new newButton2("Eliminar");
        panelAcciones.add(btnAgregar);
        panelAcciones.add(btnEliminar);
        panelCentral.add(panelAcciones, BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior para resumen y botones de confirmar/cancelar
        JPanel panelResumen = new JPanel();
        lblTotal = new JLabel("Total: $0.00");
        panelResumen.add(lblTotal);
        btnConfirmar = new newButton2("Confirmar Venta");
        btnCancelar = new newButton2("Cancelar Venta");
        panelResumen.add(btnConfirmar);
        panelResumen.add(btnCancelar);
        add(panelResumen, BorderLayout.SOUTH);

        // Agregar listeners
        agregarListeners();
    }

    private void agregarListeners() {
        btnConsumidorFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarConsumidorFinal();
            }
        });

        btnConFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirDialogoFactura();
            }
        });

        txtCodigoBarras.addActionListener(e -> buscarProductoPorCodigo());

        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarProducto();
            }
        });

        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarProducto();
            }
        });

        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarVenta();
            }
        });

        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarVenta();
            }
        });
    }

    private void seleccionarConsumidorFinal() {
        // Implementar lógica para consumidor final
    }

    private void abrirDialogoFactura() {
        // Implementar diálogo para datos de factura
    }

    private void buscarProductoPorCodigo() {
        // Implementar búsqueda de producto por código de barras
    }

    private void agregarProducto() {
        // Implementar lógica para agregar producto
    }

    private void eliminarProducto() {
        // Implementar lógica para eliminar producto
    }

    private void confirmarVenta() {
        // Implementar lógica para confirmar venta
    }

    private void cancelarVenta() {
        // Implementar lógica para cancelar venta
    }
}
