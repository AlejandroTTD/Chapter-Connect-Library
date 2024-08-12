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
        // aqui logica para buscar la venta
        resultadoArea.setText("Buscando venta: " + busqueda);
    }

    private void guardarCambios() {
        // aqui logica para guardar los cambios
        resultadoArea.setText("Guardando cambios...");
    }

    private void eliminarVenta() {
        // aqui logica para eliminar la venta
        resultadoArea.setText("Eliminando venta...");
    }
}
