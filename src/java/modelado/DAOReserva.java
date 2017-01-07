package modelado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.Reserva;

public class DAOReserva implements operaciones{
    conexion db = new conexion();
    
    @Override
    public String insertar(Object obj) {
        Reserva r = (Reserva) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "INSERT INTO reserva(idReserva, cUsuario, idAsiento, cTarifa) VALUES(NULL,?,?,?)";
        String respuesta = "";
        
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
            pst.setInt(1, r.getcUsuario());
            pst.setInt(2, r.getIdAsiento());
            pst.setInt(3, r.getcTarifa());

            int filas = pst.executeUpdate();
            respuesta = "Se insertaron "+filas+" elementos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        Reserva r = (Reserva) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "DELETE FROM reserva WHERE idReserva=?";
        String respuesta = "";
       
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
           
            pst.setInt(1, r.getIdReserva());
            
            int filas = pst.executeUpdate();
            respuesta = "Se insertaron "+filas+" elementos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return respuesta;
    }

    @Override
    public List<Reserva> listar() {
        List<Reserva> datos = new ArrayList<Reserva>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM reserva";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                //datos.add(new Reserva(res.getInt("idReserva"),res.getInt("cUsuario"),res.getInt("cAvion")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }

    @Override
    public List<Reserva> filtrar(String campo, String criterio) {
        List<Reserva> datos = new ArrayList<Reserva>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM reserva WHERE "+campo+" LIKE '%"+criterio+"%'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                //datos.add(new Reserva(res.getInt("idReserva"),res.getInt("cUsuario"),res.getInt("cAvion")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
