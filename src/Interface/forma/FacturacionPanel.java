package Interface.forma;

import javax.swing.*;

import BusinessLogic.ClienteBL;
import BusinessLogic.Detalle_VentaBL;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Interface.Customer.newButton;
import Interface.Customer.newButton2;

import DataAccess.DTO.ClienteDTO;
import DataAccess.DTO.Detalle_VentaDTO;
import DataAccess.DTO.LibroDTO;
import DataAccess.ClienteDAO;
import DataAccess.LibroDAO;
import BusinessLogic.LibroBL;
import BusinessLogic.ClienteBL;
import Interface.forma.EmailService;

import java.util.ArrayList;
import java.util.List;

public class FacturacionPanel extends JPanel {
    private newButton btnConsumidorFinal, btnConFactura;
    private JTextField txtCodigoBarras;
    private JTextField nombreClienteField;
    private JList<String> listaProductos;
    private DefaultListModel<String> modeloLista;
    private JTextField txtCantidad;
    private JLabel lblTotal;
    private newButton2 btnAgregar, btnEliminar, btnConfirmar, btnCancelar;

    private ClienteBL clienteBL = new ClienteBL();
    private LibroBL libroBL = new LibroBL();

    private boolean agregarCliente(ClienteDTO cliente) throws Exception {
        try {
            return clienteBL.create(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public FacturacionPanel() {
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
                try {
                    abrirDialogoFactura();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    private void abrirDialogoFactura() throws Exception {
        String nombreCliente = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
        String apellidoCliente = JOptionPane.showInputDialog(this, "Ingrese el apellido del cliente:");
        String correoCliente = JOptionPane.showInputDialog(this, "Ingrese el correo del cliente:");

        if (nombreCliente != null && !nombreCliente.isEmpty() &&
                apellidoCliente != null && !apellidoCliente.isEmpty() &&
                correoCliente != null && !correoCliente.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Venta registrada para: " + nombreCliente + " " + apellidoCliente);

            Integer idEntidadTipo = 1; // Aquí defines el ID_EntidadTipo según tu lógica
            ClienteDTO cliente = new ClienteDTO(idEntidadTipo, nombreCliente, apellidoCliente, correoCliente);

            boolean clienteAgregado = agregarCliente(cliente);
            if (clienteAgregado) {
                JOptionPane.showMessageDialog(this,
                        "Cliente agregado a la base de datos: " + nombreCliente + " " + apellidoCliente);
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar cliente a la base de datos.");
            }

            btnConFactura.setEnabled(false);
            btnConsumidorFinal.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nombre, apellido o correo de cliente inválido. Operación cancelada.");
        }
    }

    private void buscarProductoPorCodigo() {
        String codigo = txtCodigoBarras.getText().trim();
        if (!codigo.isEmpty()) {
            try {
                LibroDTO libro = libroBL.readBy(codigo);
                if (libro != null) {
                    modeloLista
                            .addElement(libro.getTitulo() + " - " + libro.getAutor() + " - $" + libro.getPrecioVenta());
                } else {
                    JOptionPane.showMessageDialog(this, "Libro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al buscar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            txtCodigoBarras.setText("");
        }
    }

    private void agregarProducto() {
        String cantidadStr = txtCantidad.getText();
        if (!cantidadStr.isEmpty()) {
            int cantidad = Integer.parseInt(cantidadStr);
            String codigo = txtCodigoBarras.getText().trim();

            if (!codigo.isEmpty() || !librosSeleccionados.isEmpty()) {
                try {
                    LibroDTO libro = null;

                    if (!codigo.isEmpty()) {
                        libro = libroBL.readBy(codigo);
                    } else {
                        libro = librosSeleccionados.get(librosSeleccionados.size() - 1);
                    }

                    if (libro != null) {
                        int cantidadDisponible = libro.getNroUnidades();
                        if (cantidad > cantidadDisponible) {
                            JOptionPane.showMessageDialog(this, "Cantidad no disponible", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        boolean found = false;
                        for (LibroDTO l : librosSeleccionados) {
                            if (l.getCodigoBarra().equals(libro.getCodigoBarra())) {
                                l.setNroUnidades(l.getNroUnidades() + cantidad);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            libro.setNroUnidades(cantidad);
                            librosSeleccionados.add(libro);
                        }

                        actualizarListaVisual();
                        actualizarTotal();
                        txtCantidad.setText("");
                        txtCodigoBarras.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Libro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al agregar el libro.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un código de barras válido o seleccione un libro.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        int indiceSeleccionado = listaProductos.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            librosSeleccionados.remove(indiceSeleccionado);
            modeloLista.remove(indiceSeleccionado);
            actualizarTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarListaVisual() {
        modeloLista.clear();
        for (LibroDTO libro : librosSeleccionados) {
            String item = libro.getNroUnidades() + " x " + libro.getTitulo() + " - " + libro.getAutor() + " - $"
                    + libro.getPrecioVenta();
            modeloLista.addElement(item);
        }
    }

    private List<LibroDTO> librosSeleccionados = new ArrayList<>();
    
    private Detalle_VentaBL detalleVentaBL = new Detalle_VentaBL();
    
    private void confirmarVenta() {
        if (librosSeleccionados != null && !librosSeleccionados.isEmpty()) {
            try {
                // Recopilar información de la venta
                StringBuilder sb = new StringBuilder();
                double total = 0;
                int idCajero = 1; // Aquí defines el ID del cajero según tu lógica

                for (LibroDTO libro : librosSeleccionados) {
                    sb.append("Título: ").append(libro.getTitulo()).append("\n");
                    sb.append("Autor: ").append(libro.getAutor()).append("\n");
                    sb.append("Género: ").append(libro.getGenero()).append("\n");
                    sb.append("Editorial: ").append(libro.getEditorial()).append("\n");
                    sb.append("Año de Publicación: ").append(libro.getAnioPublicacion()).append("\n");
                    sb.append("Precio Venta: $").append(libro.getPrecioVenta()).append("\n");
                    sb.append("Cantidad: ").append(libro.getNroUnidades()).append("\n\n");
                    total += libro.getPrecioVenta() * libro.getNroUnidades();

                    // Crear y guardar el detalle de la venta
                    Detalle_VentaDTO detalleVenta = new Detalle_VentaDTO(
                            null, // ID_Detalle_Venta se autogenera
                            idCajero,
                            1, // ID_Cliente, si es consumidor final, puede ser null o 1 según tu lógica
                            libro.getID_Libro(),
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                            libro.getNroUnidades(),
                            libro.getPrecioVenta(),
                            libro.getPrecioVenta() * libro.getNroUnidades(),
                            "A", // Estado activo
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                            null);
                    detalleVentaBL.create(detalleVenta);
                }

                String datosCompra = sb.toString();
                String cuerpoCorreo = "Detalles de la compra:\n\n" + datosCompra + "Total: $" + total;

                // Correo del cliente
                String correoCliente = "cliente@example.com"; // Obtén el correo real del cliente
                String asunto = "Detalles de la Compra";

                // Crear instancia de EmailService
                EmailService emailService = new EmailService();
                emailService.sendEmail(correoCliente, asunto, cuerpoCorreo, null); // No adjunta archivo

                JOptionPane.showMessageDialog(this, "Venta confirmada y detalles enviados por correo.");
                limpiarVenta();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al confirmar la venta o enviar los detalles.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
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
        double total = 0;
        for (LibroDTO libro : librosSeleccionados) {
            total += libro.getPrecioVenta() * libro.getNroUnidades();
        }
        lblTotal.setText(String.format("Total: $%.2f", total));
    }

    private void limpiarVenta() {
        modeloLista.clear();
        librosSeleccionados.clear(); // Limpiar la lista de productos seleccionados
        txtCodigoBarras.setText("");
        txtCantidad.setText("");
        lblTotal.setText("Total: $0.00");
        btnConsumidorFinal.setEnabled(true);
        btnConFactura.setEnabled(true);
    }

}
