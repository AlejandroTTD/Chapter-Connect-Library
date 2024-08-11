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
        String query = " INSERT INTO Cajero (Nombre, BarCode, Precio, id_Seccion, id_Categoria) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getBarcode());
            pstmt.setDouble(3, entity.getPrecio());
            pstmt.setInt(4, entity.getIdSeccion());
            pstmt.setInt(5, entity.getIdCategoria());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new prjException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CajeroDTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public boolean update(CajeroDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CajeroDTO readBy(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }

}
