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
        panelCodigoBarras.add(new JLabel("Codigo de Barras:"));
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
        JOptionPane.showMessageDialog(this, "Venta con Consumidor Final seleccionada");
        btnConsumidorFinal.setEnabled(false);
        btnConFactura.setEnabled(true);
    }

    private void abrirDialogoFactura() {
        String nombreCliente = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
        if (nombreCliente != null && !nombreCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Venta registrada para: " + nombreCliente);
            btnConFactura.setEnabled(false);
            btnConsumidorFinal.setEnabled(true);
        }
    }

    private void buscarProductoPorCodigo() {
        String codigo = txtCodigoBarras.getText();
        if (!codigo.isEmpty()) {
            // aqui iria lagica real de busqueda en la base de datos
            String producto = "Producto " + codigo;
            modeloLista.addElement(producto);
            txtCodigoBarras.setText("");
        }
    }

    private void agregarProducto() {
        String cantidad = txtCantidad.getText();
        if (!cantidad.isEmpty() && !listaProductos.isSelectionEmpty()) {
            String productoSeleccionado = listaProductos.getSelectedValue();
            modeloLista.addElement(cantidad + " x " + productoSeleccionado);
            txtCantidad.setText("");
            actualizarTotal();
        }
    }

    private void eliminarProducto() {
        int indiceSeleccionado = listaProductos.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            modeloLista.remove(indiceSeleccionado);
            actualizarTotal();
        }
    }

    private void confirmarVenta() {
        if (modeloLista.getSize() > 0) {
            JOptionPane.showMessageDialog(this, "Venta confirmada por un total de " + lblTotal.getText());
            limpiarVenta();
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en la venta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarVenta() {
        if (JOptionPane.showConfirmDialog(this, "¿Esta seguro de cancelar la venta?", "Confirmar cancelacion",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpiarVenta();
        }
    }

    private void actualizarTotal() {
        // Aquí iría la lógica real para calcular el total
        double total = modeloLista.getSize() * 10.0; // Simulación: cada item vale 10
        lblTotal.setText(String.format("Total: $%.2f", total));
    }

    private void limpiarVenta() {
        modeloLista.clear();
        txtCodigoBarras.setText("");
        txtCantidad.setText("");
        lblTotal.setText("Total: $0.00");
        btnConsumidorFinal.setEnabled(true);
        btnConFactura.setEnabled(true);
    }

}
