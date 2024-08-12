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

import DataAccess.DTO.LibroDTO;
import Framework.PatException;
public class LibroDAO extends SQLiteDataHelper implements IDAO_B <LibroDTO>{

    // @Override
    // public boolean create(LibroDTO entity) throws Exception {
    //     String query = " INSERT INTO Proveedor (ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //     try {
    //         Connection conexion = openConnection();
    //         PreparedStatement pstmt = conexion.prepareStatement(query);
    //         pstmt.setInt(1, entity.getID_Proveedor());
    //         pstmt.setString(2, entity.getTitulo());
    //         pstmt.setString(3, entity.getAutor());
    //         pstmt.setString(4, entity.getGenero());
    //         pstmt.setString(5, entity.getEditorial());
    //         pstmt.setString(6, entity.getAnioPublicacion());
    //         pstmt.setFloat(7, entity.getPrecioVenta());
    //         pstmt.setFloat(8, entity.getPrecioCompra());
    //         pstmt.setString(9, entity.getCodigoBarra());
    //         pstmt.setInt(10, entity.getNroUnidades());
    //         pstmt.executeUpdate();

    //         return true;
    //     } catch (SQLException e) {
    //         throw new PatException(e.getMessage(), getClass().getName(), "create()");
    //     }
    // }
    
    public boolean create(LibroDTO entity) throws Exception {
        String query = "INSERT INTO Libro (ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setInt(1, entity.getID_Proveedor());
            pstmt.setString(2, entity.getTitulo());
            pstmt.setString(3, entity.getAutor());
            pstmt.setString(4, entity.getGenero());
            pstmt.setString(5, entity.getEditorial());
            pstmt.setString(6, entity.getAnioPublicacion());
            pstmt.setFloat(7, entity.getPrecioVenta());
            pstmt.setFloat(8, entity.getPrecioCompra());
            pstmt.setString(9, entity.getCodigoBarra());
            pstmt.setInt(10, entity.getNroUnidades());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    // Similar para update(), delete(), readBy() - asegurarse de que los nombres de
    // las columnas y tablas sean correctos

    @Override
    public List<LibroDTO> readAll() throws Exception {
        List <LibroDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Libro  "
                    +", ID_Proveedor    "
                    +", titulo            "
                    +", autor            "
                    +", genero           "
                    +", editorial            "
                    +", anioPublicacion            "
                    +", precioVenta            "
                    +", precioCompra            "
                    +", codigoBarra            "
                    +", nroUnidades            "
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
                LibroDTO libroDTO = new LibroDTO(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getFloat(8),
                            rs.getFloat(9),
                            rs.getString(10),
                            rs.getInt(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getString(14));
                lst.add(libroDTO);
            }
        } catch (SQLException e){
            throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(LibroDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Libro SET ID_Proveedor = ?, titulo = ?, autor = ?, genero = ?, editorial = ?, anioPublicacion = ?, precioVenta = ?, precioCompra = ?, nroUnidades = ?, FechaModifica = ? WHERE codigoBarra = ?";

        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);

            pstmt.setInt(1, entity.getID_Proveedor());
            pstmt.setString(2, entity.getTitulo());
            pstmt.setString(3, entity.getAutor());
            pstmt.setString(4, entity.getGenero());
            pstmt.setString(5, entity.getEditorial());
            pstmt.setString(6, entity.getAnioPublicacion());
            pstmt.setFloat(7, entity.getPrecioVenta());
            pstmt.setFloat(8, entity.getPrecioCompra());
            pstmt.setInt(9, entity.getNroUnidades());
            pstmt.setString(10, dtf.format(now));
            pstmt.setString(11, entity.getCodigoBarra());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "update()");
        } 
    }

    @Override
    public boolean delete(String codigoB) throws Exception {
        String query = "UPDATE Libro SET Estado = ? WHERE codigoBarra = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setString(2, codigoB);

            return true;
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public LibroDTO readBy(String codigoB) throws Exception {
        LibroDTO libroDTO = null;
        String query = "SELECT ID_Libro, ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades, Estado, FechaCreacion, FechaModifica FROM Libro WHERE Estado = 'A' AND codigoBarra = ?";
        try {
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, codigoB);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                libroDTO = new LibroDTO(
                        rs.getInt("ID_Libro"),
                        rs.getInt("ID_Proveedor"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getString("editorial"),
                        rs.getString("anioPublicacion"),
                        rs.getFloat("precioVenta"),
                        rs.getFloat("precioCompra"),
                        rs.getString("codigoBarra"),
                        rs.getInt("nroUnidades"),
                        rs.getString("Estado"),
                        rs.getString("FechaCreacion"),
                        rs.getString("FechaModifica"));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return libroDTO;
    }
}
