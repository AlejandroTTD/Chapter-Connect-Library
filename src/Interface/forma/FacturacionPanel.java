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
        // Logica para buscar la venta
        if (busqueda.isEmpty()) {
            resultadoArea.setText("Por favor, ingrese un termino de busqueda.");
        } else {
            // implementar busqueda real en la base de datos
            resultadoArea.setText("Resultados de la búsqueda para: " + busqueda + "\n" +
                    "Venta encontrada: ID 12345, Fecha: 2024-08-12, Total: $100.00");
        }
    }

    private void guardarCambios() {
        // Logica para guardar los cambios
        String datosActuales = resultadoArea.getText();
        if (datosActuales.contains("Venta encontrada")) {
            // implementar logica real para guardar en la base de datos
            resultadoArea.setText("Cambios guardados exitosamente.");
        } else {
            resultadoArea.setText("No hay datos para guardar. Realice una busqueda primero.");
        }
    }

    private void eliminarVenta() {
        // logica para eliminar la venta
        String datosActuales = resultadoArea.getText();
        if (datosActuales.contains("Venta encontrada")) {
            // implementar logica real para eliminar de la base de datos
            int opcion = JOptionPane.showConfirmDialog(this,
                    "¿Esta seguro de que desea eliminar esta venta?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                resultadoArea.setText("Venta eliminada exitosamente.");
            } else {
                resultadoArea.setText("Eliminacion cancelada.");
            }
        } else {
            resultadoArea.setText("No hay venta seleccionada para eliminar.");
        }
    }
}
