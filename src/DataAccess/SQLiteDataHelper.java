package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:Database//BDLibreria.sqlite";
    private static Connection conexion = null;

    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(conexion == null)
                conexion = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e;
        }
        return conexion;
    }

    protected static void closeConnection() throws Exception{
        try {
            if(conexion != null)
               conexion.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
