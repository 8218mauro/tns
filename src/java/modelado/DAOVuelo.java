package modelado;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uml.Tarifa;
import uml.Vuelo;

public class DAOVuelo implements operaciones{
    conexion db = new conexion();
    
    @Override
    public String insertar(Object obj) {
        Vuelo v = (Vuelo) obj;
        Connection conn;
        PreparedStatement pst;
        String query = "INSERT INTO vuelo VALUES(?,?,?,?,?,?,?)";
        String respuesta = "";
       /* 
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            pst = conn.prepareStatement(query);
            
            pst.setInt(1, v.getCoAvion());
            pst.setInt(2, 0);
            pst.setString(3, v.getcOrigen());
            pst.setString(4, v.getcDestino());
            pst.setDate(5, (Date) v.getfSalida());
            pst.setDate(6, (Date) v.getfLlegada());
            pst.setInt(7, v.getaDisponibles());

            int filas = pst.executeUpdate();
            respuesta = "Se insertaron "+filas+" elementos";
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        }*/
        return respuesta; 
    }

    
    public List<Vuelo> consultarVuelo(int idVuelo){
        List<Vuelo> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT v.idVuelo, v.cAvion, v.cOrigen, v.cDestino, v.fSalida, v.fLlegada, v.aDsiponibles FROM vuelo v WHERE v.idVuelo="+idVuelo+"";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Vuelo(res.getInt("idVuelo"),res.getInt("cAvion"),res.getString("cOrigen"),res.getString("cDestino"),res.getDate("fSalida"),res.getDate("fLlegada"),res.getTime("hSalida"),res.getTime("hLlegada"),res.getInt("aDisponibles")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
    
     public List<Vuelo> consultarVueloPorFecha(String cOrigen, String cDestino, Date fSalida){
        List<Vuelo> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT v.idVuelo, v.cAvion, v.cOrigen, v.cDestino, v.fSalida, v.fLlegada, v.hSalida, v.hLlegada, v.aDisponibles FROM vuelo v WHERE v.cOrigen='"+cOrigen+"' and v.cDestino='"+cDestino+"' and v.fSalida>='"+fSalida+"' ";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Vuelo(res.getInt("idVuelo"),res.getInt("cAvion"),res.getString("cOrigen"),res.getString("cDestino"),res.getDate("fSalida"),res.getDate("fLlegada"),res.getTime("hSalida"),res.getTime("hLlegada"),res.getInt("aDisponibles")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
     
    public List<Vuelo> consultarVueloPorPrecio(String cOrigen, String cDestino, Date fSalida, double pinicial, double pfinal){
        List<Vuelo> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT v.idVuelo, v.cAvion, v.cOrigen, v.cDestino, v.fSalida, v.fLlegada, v.hSalida, v.hLlegada, v.aDisponibles, t.idTarifa, t.cVuelo, t.costo  FROM vuelo v, tarifa t WHERE v.cOrigen='"+cOrigen+"' and v.cDestino='"+cDestino+"' and v.fSalida>='"+fSalida+"' AND t.cVuelo=v.idVuelo AND t.costo>="+pinicial+" AND t.costo<="+pfinal+"";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Vuelo(res.getInt("idVuelo"),res.getInt("cAvion"),res.getString("cOrigen"),res.getString("cDestino"),res.getDate("fSalida"),res.getDate("fLlegada"),res.getTime("hSalida"),res.getTime("hLlegada"),res.getInt("aDisponibles")));
                //datos.add(new Tarifa(res.getInt("idTarifa"),res.getInt("cVuelo"), res.getDouble("costo")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
    
    @Override
    public List<Vuelo> filtrar(String campo, String criterio) {
        List<Vuelo> datos = new ArrayList<Vuelo>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM vuelo WHERE "+campo+" LIKE '%"+criterio+"%'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                //datos.add(new Vuelo(res.getInt("idVuelo"),res.getInt("cReserva"),res.getInt("costo"),res.getString("cOrigen"),res.getString("cDestino"),res.getDate("fSalida"),res.getDate("fLlegada"),res.getInt("nSilla")));
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

    @Override
    public List<?> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
