package Interface.forma;

import javax.swing.*;
import java.awt.*;
import Interface.Customer.newButton;
import Interface.Customer.newButton2;

public class ComprasPanel extends JPanel {

    private JTextField proveedorField;
    private JTextField productoField;
    private JTextField cantidadField;
    private JTextField precioField;
    private JLabel totalCompraLabel;
    private JTextField nombreProveedorField;
    private JTextField direccionProveedorField;
    private JTextField telefonoProveedorField;
    private JTextField buscarProveedorField;
    private JTextField nuevoNombreProveedorField;
    private JTextField nuevaDireccionProveedorField;

    public ComprasPanel() {
        setLayout(new BorderLayout());

        JPanel nuevaCompraPanel = crearNuevaCompraPanel();
        JPanel registrarProveedorPanel = crearRegistrarProveedorPanel();
        JPanel modificarProveedorPanel = crearModificarProveedorPanel();

        add(nuevaCompraPanel, BorderLayout.NORTH);
        add(registrarProveedorPanel, BorderLayout.CENTER);
        add(modificarProveedorPanel, BorderLayout.SOUTH);
    }

    private JPanel crearNuevaCompraPanel() {
        JPanel nuevaCompraPanel = new JPanel(new GridLayout(4, 1));
        nuevaCompraPanel.setBorder(BorderFactory.createTitledBorder("Nueva Compra"));

        nuevaCompraPanel.add(crearProveedorPanel());
        nuevaCompraPanel.add(crearProductoPanel());
        nuevaCompraPanel.add(crearResumenPanel());

        return nuevaCompraPanel;
    }

    private JPanel crearProveedorPanel() {
        JPanel proveedorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        proveedorPanel.add(new JLabel("Seleccionar Proveedor:"));
        proveedorField = new JTextField(20);
        proveedorPanel.add(proveedorField);
        newButton buscarProveedorButton = new newButton("Buscar");
        proveedorPanel.add(buscarProveedorButton);
        return proveedorPanel;
    }

    private JPanel crearProductoPanel() {
        JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        productoPanel.add(new JLabel("Producto:"));
        productoField = new JTextField(15);
        productoPanel.add(productoField);
        productoPanel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField(5);
        productoPanel.add(cantidadField);
        productoPanel.add(new JLabel("Precio Compra:"));
        precioField = new JTextField(10);
        productoPanel.add(precioField);
        newButton agregarProductoButton = new newButton("Agregar Producto");
        productoPanel.add(agregarProductoButton);
        newButton2 eliminarProductoButton = new newButton2("Eliminar Producto");
        productoPanel.add(eliminarProductoButton);

        agregarProductoButton.addActionListener(e -> agregarProducto());
        eliminarProductoButton.addActionListener(e -> eliminarProducto());

        return productoPanel;
    }

    private JPanel crearResumenPanel() {
        JPanel resumenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        resumenPanel.add(new JLabel("Total Compra:"));
        totalCompraLabel = new JLabel("$0.00");
        resumenPanel.add(totalCompraLabel);
        newButton confirmarCompraButton = new newButton("Confirmar Compra");
        resumenPanel.add(confirmarCompraButton);
        newButton2 cancelarCompraButton = new newButton2("Cancelar Compra");
        resumenPanel.add(cancelarCompraButton);

        confirmarCompraButton.addActionListener(e -> confirmarCompra());
        cancelarCompraButton.addActionListener(e -> cancelarCompra());

        return resumenPanel;
    }

    private JPanel crearRegistrarProveedorPanel() {
        JPanel registrarProveedorPanel = new JPanel(new GridLayout(4, 2));
        registrarProveedorPanel.setBorder(BorderFactory.createTitledBorder("Registrar Proveedor"));

        registrarProveedorPanel.add(new JLabel("Nombre:"));
        nombreProveedorField = new JTextField(20);
        registrarProveedorPanel.add(nombreProveedorField);

        registrarProveedorPanel.add(new JLabel("Dirección:"));
        direccionProveedorField = new JTextField(20);
        registrarProveedorPanel.add(direccionProveedorField);

        registrarProveedorPanel.add(new JLabel("Teléfono:"));
        telefonoProveedorField = new JTextField(20);
        registrarProveedorPanel.add(telefonoProveedorField);

        newButton guardarProveedorButton = new newButton("Guardar Proveedor");
        registrarProveedorPanel.add(guardarProveedorButton);
        newButton2 cancelarRegistroButton = new newButton2("Cancelar Registro");
        registrarProveedorPanel.add(cancelarRegistroButton);

        guardarProveedorButton.addActionListener(e -> guardarProveedor());
        cancelarRegistroButton.addActionListener(e -> cancelarRegistro());

        return registrarProveedorPanel;
    }

    private JPanel crearModificarProveedorPanel() {
        JPanel modificarProveedorPanel = new JPanel(new GridLayout(4, 2));
        modificarProveedorPanel.setBorder(BorderFactory.createTitledBorder("Modificar Proveedor"));

        modificarProveedorPanel.add(new JLabel("Buscar Proveedor:"));
        buscarProveedorField = new JTextField(20);
        modificarProveedorPanel.add(buscarProveedorField);

        modificarProveedorPanel.add(new JLabel("Nuevo Nombre:"));
        nuevoNombreProveedorField = new JTextField(20);
        modificarProveedorPanel.add(nuevoNombreProveedorField);

        modificarProveedorPanel.add(new JLabel("Nueva Dirección:"));
        nuevaDireccionProveedorField = new JTextField(20);
        modificarProveedorPanel.add(nuevaDireccionProveedorField);

        newButton guardarCambioButton = new newButton("Guardar Cambio");
        modificarProveedorPanel.add(guardarCambioButton);
        newButton2 cancelarCambioButton = new newButton2("Cancelar Cambio");
        modificarProveedorPanel.add(cancelarCambioButton);

        guardarCambioButton.addActionListener(e -> guardarCambio());
        cancelarCambioButton.addActionListener(e -> cancelarCambio());

        return modificarProveedorPanel;
    }

    private void agregarProducto() {
        // Lógica para agregar producto
    }

    private void eliminarProducto() {
        // Lógica para eliminar producto
    }

    private void confirmarCompra() {
        // Lógica para confirmar compra
    }

    private void cancelarCompra() {
        // Lógica para cancelar compra
    }

    private void guardarProveedor() {
        // Lógica para guardar proveedor
    }

    private void cancelarRegistro() {
        // Lógica para cancelar registro
    }

    private void guardarCambio() {
        // Lógica para guardar cambio
    }

    private void cancelarCambio() {
        // Lógica para cancelar cambio
    }
}