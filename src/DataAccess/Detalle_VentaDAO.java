package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.Detalle_VentaDTO;
import Framework.PatException;
public class Detalle_VentaDAO extends SQLiteDataHelper implements IDAO <Detalle_VentaDTO>{
    
    @Override
    public boolean create(Detalle_VentaDTO entity) throws Exception {
        String query = " INSERT INTO Detalle_Venta (ID_Cajero, ID_Cliente, ID_Libro, FechaVenta, Cantidad, PrecioUnitario, Total) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, entity.getID_Cajero());
            pstmt.setInt(2, entity.getID_Cliente());
            pstmt.setInt(3, entity.getID_Libro());
            pstmt.setString(4, entity.getFechaVenta());
            pstmt.setInt(5, entity.getCantidad());
            pstmt.setFloat(6, entity.getPrecioUnitario());
            pstmt.setFloat(7, entity.getTotal());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<Detalle_VentaDTO> readAll() throws Exception {
        List<Detalle_VentaDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Detalle_Venta, ID_Cajero, ID_Cliente, ID_Libro, FechaVenta, Cantidad, PrecioUnitario, Total, Estado, FechaCreacion, FechaModifica "
                + "FROM Detalle_Venta "
                + "WHERE Estado = 'A'";
        try {
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Detalle_VentaDTO detalle_VentaDTO = new Detalle_VentaDTO(
                        rs.getObject("ID_Detalle_Venta"),
                        rs.getInt("ID_Cajero"),
                        rs.getInt("ID_Cliente"),
                        rs.getInt("ID_Libro"),
                        rs.getString("FechaVenta"),
                        rs.getInt("Cantidad"),
                        rs.getFloat("PrecioUnitario"),
                        rs.getDouble("Total"),
                        rs.getString("Estado"),
                        rs.getString("FechaCreacion"),
                        rs.getObject("FechaModifica"));
                lst.add(detalle_VentaDTO);
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }
    
    @Override
    public boolean update(Detalle_VentaDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Detalle_Venta SET ID_Cajero = ?, ID_Cliente = ?, ID_Libro = ?, FechaVenta = ?, Cantidad = ?, PrecioUnitario = ?, Total = ?,  FechaModifica = ? WHERE ID_Libro = ?";

        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setInt(1,entity.getID_Cajero());
            pstmt.setInt(2,entity.getID_Cliente());
            pstmt.setInt(3, entity.getID_Libro());
            pstmt.setString(4, entity.getFechaVenta());
            pstmt.setInt(5, entity.getCantidad());
            pstmt.setFloat(6, entity.getPrecioUnitario());
            pstmt.setFloat(7, entity.getTotal());
            pstmt.setString(8,dtf.format(now));
            pstmt.setInt(9, entity.getID_Libro());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Detalle_Venta SET Estado = ? WHERE ID_Libro = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1,"X");
            pstmt.setInt(2, id);

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public Detalle_VentaDTO readBy(Integer id) throws Exception {
        Detalle_VentaDTO detalle_VentaDTO = null; // Inicializa a null
        String query = "SELECT ID_Detalle_Venta, ID_Cajero, ID_Cliente, ID_Libro, FechaVenta, Cantidad, PrecioUnitario, Total, Estado, FechaCreacion, FechaModifica "
                + "FROM Detalle_Venta "
                + "WHERE Estado = 'A' AND ID_Libro = ?";

        try (Connection conexion = openConnection();
                PreparedStatement pstmt = conexion.prepareStatement(query)) {

            pstmt.setInt(1, id); // Establece el parámetro en la consulta

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    detalle_VentaDTO = new Detalle_VentaDTO(
                            rs.getObject("ID_Detalle_Venta"),
                            rs.getInt("ID_Cajero"),
                            rs.getInt("ID_Cliente"),
                            rs.getInt("ID_Libro"),
                            rs.getString("FechaVenta"),
                            rs.getInt("Cantidad"),
                            rs.getFloat("PrecioUnitario"),
                            rs.getDouble("Total"),
                            rs.getString("Estado"),
                            rs.getString("FechaCreacion"),
                            rs.getObject("FechaModifica"));
                }
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }

        return detalle_VentaDTO;
    }

}
