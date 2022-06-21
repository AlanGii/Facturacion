/*
Conectando la Base de datos
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/santodiablocustom";
    PreparedStatement ps=null;
    ResultSet rs=null;
    //Establecer la conexion
    public Conectar() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);//Data abse connection
            if(conn != null){
                System.out.print("Se conecto Al 100 compa!.");
                System.out.println();
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.print("No se conecto ni maiz");
            System.out.println();
            
        }
    }
    
    //Establecer la conexion
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
        if(conn == null){
            System.out.print("");
            System.out.print("Se desconecto bien chido.");
            System.out.println();
        }
    }
    
    public void Consulta(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            ps=conn.prepareStatement("SELECT*FROM usuarios WHERE idusuarios=?");
            ps.setInt(1, 2);
            rs=ps.executeQuery();
            
            while(rs.next()){
                int id_client=rs.getInt(1);
                String nombre=rs.getString(2);
                String apellidoP=rs.getString(3);
                String apellidoM=rs.getString(4);
                System.out.println("Id del cliente: "+id_client);
                System.out.println("Nombre: "+nombre);
                System.out.println("Apellido Paterno: "+apellidoP);
                System.out.println("Apellido Materno: "+apellidoM);
                System.out.println();
            
            }
            
        } catch (Exception e) {
        }
        
    }
    
    
   
}
