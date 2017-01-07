package modelado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.Usuario;

public class DAOUsuario implements operaciones{
    conexion db = new conexion();
    
    @Override
    public String insertar(Object obj) {
        Usuario u = (Usuario) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "INSERT INTO usuario VALUES(?,?,?,?,?)";
        String respuesta = "";
        
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
            pst.setInt(1, u.getCc());
            pst.setString(2, u.getNombres());
            pst.setString(3, u.getApellidos());
            pst.setInt(4,u.getEdad());
            pst.setString(5, u.getCorreo());
            
            int filas = pst.executeUpdate();
            respuesta = "Se insertaron "+filas+" elementos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta;
    }

    @Override
    public String eliminar(Object obj) {
        Usuario u = (Usuario) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "DELETE FROM usuario WHERE cc=?";
        String respuesta = "";
       
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
           
            pst.setInt(1, u.getCc());
            
            int filas = pst.executeUpdate();
            respuesta = "Se eliminaron "+filas+" elementos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return respuesta;
    }

    @Override
    public String modificar(Object obj) {
        Usuario u = (Usuario) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "UPDATE usuario set cc=?, nombres=?, apellidos=?, edad=?, correo=?, contrasena=? WHERE id=?";
        String respuesta = "";

        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
            
            pst.setInt(1, u.getCc());
            pst.setString(2, u.getNombres());
            pst.setString(3, u.getApellidos());
            pst.setInt(4,u.getEdad());
            pst.setString(5, u.getCorreo());
            pst.setInt(1, u.getCc());
            
            int filas = pst.executeUpdate();
            respuesta = "Se modifico la fila "+filas;
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return respuesta;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> datos = new ArrayList<Usuario>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM persona";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Usuario(res.getInt("cc"),res.getString("nombres"),res.getString("apellidos"),res.getInt("edad"),res.getString("correo")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }

    @Override
    public List<Usuario> filtrar(String campo, String criterio) {
        List<Usuario> datos = new ArrayList<Usuario>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM uuario WHERE "+campo+" LIKE '%"+criterio+"%'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Usuario(res.getInt("cc"),res.getString("nombres"),res.getString("apellidos"),res.getInt("edad"),res.getString("correo")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
    
     public List<Usuario> verificar(String email, int pass) {
        List<Usuario> datos = new ArrayList<>();
        Usuario u = new Usuario();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM usuario WHERE correo='"+email+"' AND cc="+pass+"";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                 datos.add(new Usuario(res.getInt("cc"),res.getString("nombres"),res.getString("apellidos"),res.getInt("edad"),res.getString("correo")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {};
        
        return datos;
        
    }
    
}
