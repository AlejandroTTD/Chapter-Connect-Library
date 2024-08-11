package Interface.forma;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.*;

public class PanelLocal extends JPanel{
    public PanelLocal() {
       // Configuración del layout
       setLayout(new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.insets = new Insets(7, 7, 7, 7);

       // Título
       JLabel titleLabel = new JLabel("Libreria");
       titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
       gbc.gridx = 0;
       gbc.gridy = 0;
       gbc.gridwidth = 2;
       add(titleLabel, gbc);

       // Grilla (mitad superior)
       String[] columnas = {"IdLocalida", "IdLocalidaPadre", "IdLocalidaEstructura", "Nombre", "Estado", "FechaCrea", "FechaModifica"};
       JTable grilla = new JTable(new Object[0][columnas.length], columnas);
       JScrollPane scrollPane = new JScrollPane(grilla);
       Dimension dimension = new Dimension(300, 200); // Establecer el tamaño preferido
       scrollPane.setPreferredSize(dimension);
       gbc.gridy = 1;
       gbc.gridwidth = 2;
       gbc.weighty = 0.5; // Hacer que ocupe la mitad superior del panel
       add(scrollPane, gbc);

       // Panel de navegación (mitad superior)
       JPanel navigationPanel = new JPanel(new FlowLayout());
       JButton firstButton = new JButton("|<");
       JButton prevButton = new JButton("<");
       JButton nextButton = new JButton(">");
       JButton lastButton = new JButton(">|");
       navigationPanel.add(firstButton);
       navigationPanel.add(prevButton);
       navigationPanel.add(nextButton);
       navigationPanel.add(lastButton);
       gbc.gridx = 0;
       gbc.gridy = 2;
       gbc.gridwidth = 2;
       gbc.weighty = 0.0; // Restablecer el peso
       add(navigationPanel, gbc);

       // Panel de ingreso (mitad inferior izquierda)
       JPanel inputPanel = new JPanel(new GridBagLayout());
       String[] etiquetas = {"IdLocalidaPadre", "IdLocalidaEstructura", "Nombre", "Estado", "FechaCrea", "FechaModifica"};
       JTextField[] camposTexto = new JTextField[etiquetas.length];
       gbc.anchor = GridBagConstraints.WEST;
       gbc.gridx = 0;
       gbc.gridy = 3;
       gbc.gridwidth = 1;
       gbc.fill = GridBagConstraints.HORIZONTAL;
       for (int i = 0; i < etiquetas.length; i++) {
           gbc.gridy = 3 + i;
           JLabel etiqueta = new JLabel(etiquetas[i]);
           camposTexto[i] = new JTextField(15);
           inputPanel.add(etiqueta, gbc);
           gbc.gridx = 1;
           inputPanel.add(camposTexto[i], gbc);
           gbc.gridx = 0;
       }
       add(inputPanel, gbc);

       // Botones de acción (mitad inferior derecha)
       JPanel buttonPanel = new JPanel(new FlowLayout());
       JButton nuevoButton = new JButton("Nuevo");
       JButton guardarButton = new JButton("Guardar");
       JButton cancelarButton = new JButton("Cancelar");
       JButton eliminarButton = new JButton("Eliminar");
       buttonPanel.add(nuevoButton);
       buttonPanel.add(guardarButton);
       buttonPanel.add(cancelarButton);
       buttonPanel.add(eliminarButton);
       gbc.gridy = 3 + etiquetas.length;
       gbc.gridx = 0;
       gbc.anchor = GridBagConstraints.SOUTH; // Alinear al pie del panel
       add(buttonPanel, gbc);
    }
}
