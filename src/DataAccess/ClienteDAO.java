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

import DataAccess.DTO.ClienteDTO;
import Framework.PatException;

public class ClienteDAO extends SQLiteDataHelper implements IDAO<ClienteDTO>{


    public boolean create(ClienteDTO entity) throws Exception {
        String query = "INSERT INTO Cliente (ID_EntidadTipo, Nombre, Apellido, Email) VALUES (?, ?, ?, ?)";
        try (Connection conexion = openConnection();
                PreparedStatement pstmt = conexion.prepareStatement(query)) {

            pstmt.setInt(1, entity.getID_EntidadTipo());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getApellido());
            pstmt.setString(4, entity.getEmail());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);

            return rowsAffected > 0;
        } catch (SQLException e) {
            // Lanzar la excepción personalizada con información adicional
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    // @Override
    // public boolean create (ClienteDTO entity) throws Exception{
    //     String query = "INSERT INTO Cliente (ID_EntidadTipo, Nombre, Apellido, Email) VALUES (?, ?, ?, ?)";
    //     try{
    //         Connection conexion = openConnection();
    //         PreparedStatement pstmt = conexion.prepareStatement(query);
    //         pstmt.setInt(1,entity.getID_EntidadTipo());
    //         pstmt.setString(2,entity.getNombre());
    //         pstmt.setString(3,entity.getApellido());
    //         pstmt.setString(4,entity.getEmail());
    //         pstmt.executeUpdate();
            
    //         return true;
    //     } catch (SQLException e) {
    //         throw new PatException(e.getMessage(),getClass().getName(),"create()");
    //     }
    // }

    @Override
    public List<ClienteDTO> readAll() throws Exception {
        List <ClienteDTO> lst = new ArrayList<>();
        String query = "SELECT ID_Cliente  "
                + ", ID_EntidadTipo    "
                + ", Nombre            "
                + ", Apellido          "
                + ", Email             "
                + ", Estado            "
                + ", FechaCreacion     "
                + ", FechaModifica     "
                + "FROM Cliente        "
                + "WHERE Estado = 'A'  "; 
        try{
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                ClienteDTO clienteDTO = new ClienteDTO(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));
                lst.add(clienteDTO);
            }
        } catch (SQLException e){
            throw new PatException(e.getMessage(),getClass().getName(),"readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ClienteDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Cajero SET Nombre = ?, Apellido = ?, Email = ?, FechaModifica = ? WHERE ID_EntidadTipo = ?";
        
        try{
            Connection conexion = openConnection();
            PreparedStatement pstmt = conexion.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getEmail());
            pstmt.setString(4, dtf.format(now));
            pstmt.setInt(5, entity.getID_EntidadTipo());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e){
            throw new PatException(e.getMessage(),getClass().getName(),"update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Cliente SET Estado = ? WHERE ID_EntidadTipo = ?";
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
    public ClienteDTO readBy(Integer id) throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO();
        String query = "SELECT ID_Cliente   "
                + ", ID_EntidadTipo    "
                + ", Nombre "
                + ", Apellido "
                + ", Email "
                + ", Estado "
                + ", FechaCreacion "
                + ", FechaModifica "
                + "FROM Cliente WHERE Estado = 'A' AND ID_EntidadTipo = " + id;
        try {
            Connection conexion = openConnection();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                clienteDTO = new ClienteDTO(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return clienteDTO; 
    }

}
