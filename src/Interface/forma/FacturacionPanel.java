package Interface.forma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.Customer.newButton;
import Interface.Customer.newButton2;
import Interface.IAStyle;

public class FacturacionPanel extends JPanel {
    private JTextField busquedaField;
    private JButton buscarButton;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;

    public FacturacionPanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        // Panel superior para la busqueda
        JPanel busquedaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        busquedaField = new JTextField(20);
        buscarButton = new newButton("Buscar");
        busquedaPanel.add(new JLabel("Buscar venta (fecha o ID):"));
        busquedaPanel.add(busquedaField);
        busquedaPanel.add(buscarButton);

        // Panel central para mostrar resultados
        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Panel inferior para botones de accion
        JPanel accionesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guardarButton = new newButton2("Guardar cambios");
        eliminarButton = new newButton2("Eliminar venta");
        accionesPanel.add(guardarButton);
        accionesPanel.add(eliminarButton);

        // Agregar componentes al panel principal
        add(busquedaPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(accionesPanel, BorderLayout.SOUTH);

        // Configurar listeners
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarVenta();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarVenta();
            }
        });
    }

    private void buscarVenta() {
        String busqueda = busquedaField.getText();
        if (busqueda.isEmpty()) {
            resultadoArea.setText("Por favor, ingrese un ID o fecha de venta.");
            return;
        }

        // conectar a base de datos o sistema de almacenamiento
        // y buscar la venta basándote en el ID o la fecha.
        // Este es un ejemplo simulado:

        boolean ventaEncontrada = false;
        String resultadoBusqueda = "";

        // Simular busqueda

        if (busqueda.matches("\\d+")) { // Si es un numero (ID)
            resultadoBusqueda = "Venta ID: " + busqueda + "\n";
            resultadoBusqueda += "Fecha: 12/08/2024\n";
            resultadoBusqueda += "Cliente: Martina D\n";
            resultadoBusqueda += "Total: $100.00";
            ventaEncontrada = true;
        } else if (busqueda.matches("\\d{2}/\\d{2}/\\d{4}")) { // Si es una fecha
            resultadoBusqueda = "Ventas en la fecha " + busqueda + ":\n";
            resultadoBusqueda += "1. ID: 1001, Cliente: Maria Garcia, Total: $150.00\n";
            resultadoBusqueda += "2. ID: 1002, Cliente: David Sanchez, Total: $200.00";
            ventaEncontrada = true;
        }

        if (ventaEncontrada) {
            resultadoArea.setText(resultadoBusqueda);
        } else {
            resultadoArea.setText("No se encontraron ventas para: " + busqueda);
        }
    }

    private void guardarCambios() {
        // implementar la lógica para guardar los cambios en tu sistema de
        // almacenamiento.
        // Por ahora, solo mostraremos un mensaje de confirmación.

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Esta seguro de que desea guardar los cambios?",
                "Confirmar guardar",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Aquí iría el codigo para guardar los cambios en la base de datos
            resultadoArea.setText("Cambios guardados exitosamente.");
        } else {
            resultadoArea.setText("Operacion de guardado cancelada.");
        }
    }

    private void eliminarVenta() {
        String idVenta = JOptionPane.showInputDialog(this, "Ingrese el ID de la venta a eliminar:");

        if (idVenta == null || idVenta.isEmpty()) {
            resultadoArea.setText("Operación cancelada.");
            return;
        }

        // verificar si la venta existe antes de intentar eliminarla
        //

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Esta seguro de que desea eliminar la venta con ID " + idVenta + "?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Aquí iría el codigo para eliminar la venta de la base de datos
            resultadoArea.setText("Venta con ID " + idVenta + " eliminada exitosamente.");
        } else {
            resultadoArea.setText("Operacion de eliminación cancelada.");
        }
    }
}
