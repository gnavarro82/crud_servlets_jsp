package datos;

import java.sql.*;
import modelo.Persona;
import java.util.*;


public class Conexion {

    protected Connection con;
    protected Statement stmt;
    protected String serverName = "localhost";
    protected String portNumber = "3306";
    protected String databaseName = "proyecto_jsp";
     protected String url = "jdbc:mysql://localhost:3306/proyecto_jsp";
    protected String userName = "root";
    protected String password = "navarro";
    protected String errString;

    public Conexion() {
    }

    public void Conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fin de Conexion

   public boolean ingreso_datos(Persona persona) {
        boolean encontrado = false;
        try {
            Conexion();
            String sql = "INSERT INTO personas VALUES('" + persona.getDni() + "','" + persona.getNombre() + "','" + persona.getEdad() + "','" + persona.getTelefono() + "')";

            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                encontrado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encontrado;
    }//fin de ingreso de datos

    public boolean eliminar(String dni) {
        boolean encontrado = false;
        try {
            Conexion();
            int i = stmt.executeUpdate("DELETE FROM personas WHERE dni = '" +dni+ "'");
            if (i > 0) {
                encontrado = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        return encontrado;
    }

    public boolean actualizar(Persona persona) {
        boolean encontrado = false;
        try {
            Conexion();
            int i = stmt.executeUpdate("UPDATE personas SET nombre = '" + persona.getNombre() + "', edad = " + persona.getEdad() + ", telefono = "
                    + persona.getTelefono() + " WHERE dni = '" + persona.getDni() + "'");
            if (i > 0) {
                encontrado = true;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return encontrado;
    }

    public ArrayList<Persona> buscar(String dni) throws Exception {
         ArrayList<Persona> personas = new ArrayList<Persona>();
        try{
        Conexion();
        ResultSet rs = stmt.executeQuery("SELECT * FROM personas WHERE dni = '" + dni + "'");
        while (rs.next()) {
            Persona persona = new Persona();
            persona.setDni((String) rs.getObject(1));
            persona.setNombre((String) rs.getObject(2));
            persona.setEdad((Integer) rs.getObject(3));
            persona.setTelefono((Integer) rs.getObject(4));
            personas.add(persona);
        }
        
        }catch(Exception e){
             e.getStackTrace();
        }
        return personas;
    }

    public ArrayList<Persona> listar() throws Exception {
        Conexion();
        ArrayList<Persona> personas = new ArrayList<Persona>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM personas");
        while (rs.next()) {
            Persona persona = new Persona();
            persona.setDni((String) rs.getObject(1));
            persona.setNombre((String) rs.getObject(2));
            persona.setEdad((Integer) rs.getObject(3));
            persona.setTelefono((Integer) rs.getObject(4));
            personas.add(persona);
        }
        return personas;
    }

}// fin de clase Conexion
