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

import DataAccess.DTO.ProveedorDTO;
import Framework.PatException;
public class ProveedorDAO extends SQLiteDataHelper implements IDAO <ProveedorDTO>{

    @Override
    public boolean create(ProveedorDTO entity) throws Exception {
        String query = " INSERT INTO Proveedor (ID_EntidadTipo, Nombre) VALUES (?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, entity.getID_EntidadTipo());
            pstmt.setString(2, entity.getNombre());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<ProveedorDTO> readAll() throws Exception {
        List <ProveedorDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Proveedor  "
                    +", ID_EntidadTipo    "
                    +", Nombre            "
                    +", Estado            "
                    +", FechaCreacion     "
                    +", FechaModifica     "
                    +"FROM Proveedor         "
                    +"WHERE Estado = 'A'  ";
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                ProveedorDTO proveedorDTO = new ProveedorDTO(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6));
                lst.add(proveedorDTO);
            }
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ProveedorDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Proveedor SET Nombre = ?, FechaModifica = ? WHERE ID_EntidadTipo = ?";

        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getID_EntidadTipo());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        } 
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Proveedor SET Estado = ? WHERE ID_EntidadTipo = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public ProveedorDTO readBy(Integer id) throws Exception {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        String query = "SELECT ID_Proveedor   "
                + ", ID_EntidadTipo    "
                + ", Nombre "
                + ", Estado "
                + ", FechaCreacion "
                + ", FechaModifica "
                + "FROM Proveedor WHERE Estado = 'A' AND ID_EntidadTipo = " + id;
        try {
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                proveedorDTO = new ProveedorDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return proveedorDTO;
    }

}
