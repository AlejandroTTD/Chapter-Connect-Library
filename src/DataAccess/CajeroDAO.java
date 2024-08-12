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

import DataAccess.DTO.CajeroDTO;
import Framework.PatException;
public class CajeroDAO extends SQLiteDataHelper implements IDAO<CajeroDTO>{

    @Override
    public boolean create(CajeroDTO entity) throws Exception {
        String query = " INSERT INTO Cajero (ID_EntidadTipo, Usuario, Contrasena) VALUES (?, ?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, entity.getID_EntidadTipo());
            pstmt.setString(2, entity.getUsuario());
            pstmt.setString(3, entity.getContrasena());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CajeroDTO> readAll() throws Exception {
        List <CajeroDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Cajero  "
                    +", ID_EntidadTipo    "
                    +", Usuario           "
                    +", Contrasena        "
                    +", Estado            "
                    +", FechaCreacion     "
                    +", FechaModifica     "
                    +"FROM Cajero         "
                    +"WHERE Estado = 'A'  ";
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                CajeroDTO cajeroDTO = new CajeroDTO(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                lst.add(cajeroDTO);
            }
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }
    

    @Override
    public boolean update(CajeroDTO entity) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Cajero SET Usuario = ?, Contrasena = ?, FechaModifica = ? WHERE ID_EntidadTipo = ?";

        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setString(1,entity.getUsuario());
            pstmt.setString(2,entity.getContrasena());
            pstmt.setString(3,dtf.format(now));
            pstmt.setInt(4, entity.getID_EntidadTipo());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Cajero SET Estado = ? WHERE ID_EntidadTipo = ?";
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
    public CajeroDTO readBy(Integer id) throws Exception {
        CajeroDTO cajeroDTO = new CajeroDTO();
        String query = "SELECT ID_Cajero   "
                    +", ID_Entidad Tipo    "
                    +", Usuario "
                    +", Contrasena "
                    +", Estado "
                    +", FechaCreacion "
                    +", FechaModifica "
                    +"FROM Cajero WHERE Estado = 'A' AND ID_Cajero = " + id;
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                cajeroDTO = new CajeroDTO(rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7));
            }
        } catch (Exception e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return cajeroDTO;
    }

}
