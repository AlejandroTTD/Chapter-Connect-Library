package Interface.forma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.Customer.newButton;
import Interface.Customer.newButton2;

public class ComprasPanel extends JPanel {

    public ComprasPanel() {
        setLayout(new BorderLayout());

        // Panel para "Nueva Compra"
        JPanel nuevaCompraPanel = new JPanel(new GridLayout(4, 1));
        nuevaCompraPanel.setBorder(BorderFactory.createTitledBorder("Nueva Compra"));

        // Seleccionar Proveedor
        JPanel proveedorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        proveedorPanel.add(new JLabel("Seleccionar Proveedor:"));
        JTextField proveedorField = new JTextField(20);
        proveedorPanel.add(proveedorField);
        newButton buscarProveedorButton = new newButton("Buscar");
        proveedorPanel.add(buscarProveedorButton);
        nuevaCompraPanel.add(proveedorPanel);

        // Agregar Producto
        JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        productoPanel.add(new JLabel("Producto:"));
        JTextField productoField = new JTextField(15);
        productoPanel.add(productoField);
        productoPanel.add(new JLabel("Cantidad:"));
        JTextField cantidadField = new JTextField(5);
        productoPanel.add(cantidadField);
        productoPanel.add(new JLabel("Precio Compra:"));
        JTextField precioField = new JTextField(10);
        productoPanel.add(precioField);
        newButton agregarProductoButton = new newButton("Agregar Producto");
        productoPanel.add(agregarProductoButton);
        newButton2 eliminarProductoButton = new newButton2("Eliminar Producto");
        productoPanel.add(eliminarProductoButton);
        nuevaCompraPanel.add(productoPanel);

        // Resumen de Compra
        JPanel resumenPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        resumenPanel.add(new JLabel("Total Compra:"));
        JLabel totalCompraLabel = new JLabel("$0.00");
        resumenPanel.add(totalCompraLabel);
        newButton confirmarCompraButton = new newButton("Confirmar Compra");
        resumenPanel.add(confirmarCompraButton);
        newButton2 cancelarCompraButton = new newButton2("Cancelar Compra");
        resumenPanel.add(cancelarCompraButton);
        nuevaCompraPanel.add(resumenPanel);

        // Panel para "Registrar Proveedor"
        JPanel registrarProveedorPanel = new JPanel(new GridLayout(3, 2));
        registrarProveedorPanel.setBorder(BorderFactory.createTitledBorder("Registrar Proveedor"));

        registrarProveedorPanel.add(new JLabel("Nombre:"));
        JTextField nombreProveedorField = new JTextField(20);
        registrarProveedorPanel.add(nombreProveedorField);

        registrarProveedorPanel.add(new JLabel("Dirección:"));
        JTextField direccionProveedorField = new JTextField(20);
        registrarProveedorPanel.add(direccionProveedorField);

        registrarProveedorPanel.add(new JLabel("Teléfono:"));
        JTextField telefonoProveedorField = new JTextField(20);
        registrarProveedorPanel.add(telefonoProveedorField);

        newButton guardarProveedorButton = new newButton("Guardar Proveedor");
        registrarProveedorPanel.add(guardarProveedorButton);
        newButton2 cancelarRegistroButton = new newButton2("Cancelar Registro");
        registrarProveedorPanel.add(cancelarRegistroButton);

        // Panel para "Modificar Proveedor"
        JPanel modificarProveedorPanel = new JPanel(new GridLayout(3, 2));
        modificarProveedorPanel.setBorder(BorderFactory.createTitledBorder("Modificar Proveedor"));

        modificarProveedorPanel.add(new JLabel("Buscar Proveedor:"));
        JTextField buscarProveedorField = new JTextField(20);
        modificarProveedorPanel.add(buscarProveedorField);

        modificarProveedorPanel.add(new JLabel("Nuevo Nombre:"));
        JTextField nuevoNombreProveedorField = new JTextField(20);
        modificarProveedorPanel.add(nuevoNombreProveedorField);

        modificarProveedorPanel.add(new JLabel("Nueva Dirección:"));
        JTextField nuevaDireccionProveedorField = new JTextField(20);
        modificarProveedorPanel.add(nuevaDireccionProveedorField);

        newButton guardarCambioButton = new newButton("Guardar Cambio");
        modificarProveedorPanel.add(guardarCambioButton);
        newButton2 cancelarCambioButton = new newButton2("Cancelar Cambio");
        modificarProveedorPanel.add(cancelarCambioButton);

        // Añadir todo al panel principal
        add(nuevaCompraPanel, BorderLayout.NORTH);
        add(registrarProveedorPanel, BorderLayout.CENTER);
        add(modificarProveedorPanel, BorderLayout.SOUTH);

        // Agregar listeners a los botones
        agregarProductoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para agregar producto
            }
        });

        eliminarProductoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para eliminar producto
            }
        });

        confirmarCompraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para confirmar compra
            }
        });

        cancelarCompraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para cancelar compra
            }
        });

        guardarProveedorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para guardar proveedor
            }
        });

        cancelarRegistroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para cancelar registro
            }
        });

        guardarCambioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para guardar cambio
            }
        });

        cancelarCambioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica para cancelar cambio
            }
        });
    }
}
