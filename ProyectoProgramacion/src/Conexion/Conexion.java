package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion{
    private static final String URL = "jdbc:sqlite:C:/Users/manel/Downloads/BaseDeDatos/sistematickets.s3db";
    
    public static Connection conectar(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexión con la base de datos establecida");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static void crearTabla(){
        String sql = "CREATE TABLE IF NOT EXISTS tickets (\n"
                + "   id INTEGER PRIMARY KEY, \n"
                + "   creador TEXT NOT NULL, \n"
                + "   fechaCreacion TEXT NOT NULL, \n"
                + "   descripcion TEXT NOT NULL, \n"
                + "   estado TEXT NOT NULL, \n"
                + "   asignadoA TEXT, \n"
                + "   atentidoPor TEXT \n"
                + ");";
        
        try(Connection conn = conectar();
                Statement stmt = conn.createStatement()){
                stmt.execute(sql);
                System.out.println("Tabla tickets ya creada o ya existente");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        crearTabla();
    }
}
