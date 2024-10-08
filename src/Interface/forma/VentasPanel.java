package Interface.forma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Interface.Customer.newButton;
import Interface.Customer.newButton2;
import Interface.IAStyle;

public class VentasPanel extends JPanel {
    private JTextField busquedaField;
    private JButton buscarButton;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;
    private JList<String> historialList;
    private List<String> historialBusquedas;
    private int ultimoId;

    public VentasPanel() {
        setLayout(new BorderLayout());
        historialBusquedas = new ArrayList<>();
        ultimoId = 123;
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

        // Panel para el historial
        historialList = new JList<>();
        JScrollPane historialScrollPane = new JScrollPane(historialList);
        historialScrollPane.setPreferredSize(new Dimension(200, 100));

        // Panel para contener el área de resultados y el historial
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(historialScrollPane, BorderLayout.EAST);

        // Panel inferior para botones de accion
        JPanel accionesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guardarButton = new newButton2("Guardar cambios");
        eliminarButton = new newButton2("Eliminar venta");
        accionesPanel.add(guardarButton);
        accionesPanel.add(eliminarButton);

        // Agregar componentes al panel principal
        add(busquedaPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
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
            resultadoArea.setText("Por favor, ingrese un termino de busqueda.");
        } else {
            ultimoId++;

            String resultado = String.format("Resultados de la busqueda para: %s\n" +
                    "Venta encontrada: ID %d, Fecha: 2024-08-12, Total: $25",
                    busqueda, ultimoId);

            resultadoArea.setText(resultado);

            // Registrar la búsqueda en el historial
            historialBusquedas.add(busqueda + " - ID: " + ultimoId);
            actualizarHistorialEnPantalla();
        }
    }

    private void actualizarHistorialEnPantalla() {
        historialList.setListData(historialBusquedas.toArray(new String[0]));
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
