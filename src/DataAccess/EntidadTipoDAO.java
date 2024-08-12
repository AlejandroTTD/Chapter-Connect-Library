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

import DataAccess.DTO.EntidadTipoDTO;
import Framework.PatException;

public class EntidadTipoDAO extends SQLiteDataHelper implements IDAO <EntidadTipoDTO> {

    @Override
    public boolean create(EntidadTipoDTO entity) throws Exception {
        String query = " INSERT INTO EntidadTipo (Nombre) VALUES (?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<EntidadTipoDTO> readAll() throws Exception{
        List <EntidadTipoDTO> lst = new ArrayList<>();
        String query = "  SELECT ID_EntidadTipo "
                      +" ,Nombre                "
                      +" ,Estado                "
                      +" ,FechaCreacion         "
                      +" ,FechaModifica         "
                      +" FROM EntidadTipo       "
                      +" WHERE Estado = 'A'     ";
        
        try {
            Connection conexion = openConnection();
            Statement stmt      = conexion.createStatement();
            ResultSet rs        = stmt.executeQuery(query);
            while (rs.next()) {
                EntidadTipoDTO eT = new EntidadTipoDTO(
                                            rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5));
                lst.add(eT);
            }
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }


    @Override
    public EntidadTipoDTO readBy(Integer id) throws Exception {
        EntidadTipoDTO eT = new EntidadTipoDTO();
        String query = " SELECT ID_EntidadTipo"
                + "     ,Nombre              "
                + "     ,Estado              "
                + "     ,FechaCreacion       "
                + "     ,FechaModifica       "
                + " FROM  EntidadTipo        "
                + " WHERE Estado = 'A' AND ID_EntidadTipo = " + id.toString();
        try {
            Connection conexion = openConnection(); // conectar a DB
            Statement stmt = conexion.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                eT = new EntidadTipoDTO(
                          rs.getInt(1) // RowNum
                        , rs.getString(2) // Nombre
                        , rs.getString(3) // Estado
                        , rs.getString(4) // FechaCreacion
                        , rs.getString(5));// FechaModifica
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return eT;
    }

    @Override
    public boolean update(EntidadTipoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, FechaModifica = ? WHERE ID_EntidadTipo = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getID_EntidadTipo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE Catalogo SET Estado = ? WHERE ID_EntidadTipo = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }
}
