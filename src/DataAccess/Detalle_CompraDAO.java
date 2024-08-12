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

import DataAccess.DTO.Detalle_CompraDTO;
import Framework.PatException;
public class Detalle_CompraDAO extends SQLiteDataHelper implements IDAO<Detalle_CompraDTO>{

    @Override
    public boolean create(Detalle_CompraDTO entity) throws Exception {
        String query = " INSERT INTO Detalle_Compra (ID_Proveedor, ID_Libro, Cantidad, PrecioUnitario, Total, FechaCompra) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, entity.getID_Proveedor());
            pstmt.setInt(2, entity.getID_Libro());
            pstmt.setInt(3, entity.getCantidad());
            pstmt.setFloat(4, entity.getPrecioUnitario());
            pstmt.setFloat(5, entity.getTotal());
            pstmt.setString(6, entity.getFechaCompra());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<Detalle_CompraDTO> readAll() throws Exception {
        List <Detalle_CompraDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Detalle_Compra  "
                    +", ID_Proveedor    "
                    +", ID_Libro    "
                    +", Cantidad           "
                    +", PrecioUnitario        "
                    +", Total            "
                    +", FechaCompra            "
                    +", Estado            "
                    +", FechaCreacion     "
                    +", FechaModifica     "
                    +"FROM Detalle_Compra         "
                    +"WHERE Estado = 'A'  ";
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Detalle_CompraDTO detalle_CompraDTO = new Detalle_CompraDTO(rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getFloat(5),
                            rs.getFloat(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10));
                lst.add(detalle_CompraDTO);
            }
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }
    

    @Override
    public boolean update(Detalle_CompraDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Detalle_Compra SET ID_Proveedor = ?, Cantidad = ?, PrecioUnitario = ?, Total = ?, FechaCompra = ?,  FechaModifica = ? WHERE ID_Libro = ?";

        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setInt(1,entity.getID_Proveedor());
            pstmt.setInt(2,entity.getCantidad());
            pstmt.setFloat(3, entity.getPrecioUnitario());
            pstmt.setFloat(4, entity.getTotal());
            pstmt.setString(5, entity.getFechaCompra());
            pstmt.setString(6,dtf.format(now));
            pstmt.setInt(7, entity.getID_Libro());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Detalle_Compra SET Estado = ? WHERE ID_Libro = ?";
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
    public Detalle_CompraDTO readBy(Integer id) throws Exception {
        Detalle_CompraDTO detalle_CompraDTO = new Detalle_CompraDTO();
        String query = "SELECT ID_Detalle_Compra  "
                + ", ID_Proveedor    "
                + ", ID_Libro    "
                + ", Cantidad           "
                + ", PrecioUnitario        "
                + ", Total            "
                + ", FechaCompra            "
                + ", Estado            "
                + ", FechaCreacion     "
                + ", FechaModifica     "
                + "FROM Detalle_Compra WHERE Estado = 'A' AND ID_Libro = " + id;
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                detalle_CompraDTO = new Detalle_CompraDTO(rs.getInt(1),
                                rs.getInt(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getFloat(5),
                                rs.getFloat(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getString(10));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return detalle_CompraDTO;
    }

}
