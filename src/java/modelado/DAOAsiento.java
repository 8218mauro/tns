package modelado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.Asiento;

public class DAOAsiento implements operaciones{
    conexion db = new conexion();

    public List<Asiento> listarAsientosDisponibles(int idAvion, int idTarifa){
        List<Asiento> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT a.idAsiento, a.cAvion FROM asiento a WHERE a.cAvion="+idAvion+" and a.idAsiento NOT IN (SELECT idAsiento FROM reserva WHERE cTarifa="+idTarifa+")";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
                datos.add(new Asiento(res.getInt("idAsiento"),res.getInt("cAvion")));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return datos;
    }
    

    @Override
    public List<Asiento> filtrar(String campo, String criterio) {
        List<Asiento> datos = new ArrayList<Asiento>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM asiento WHERE "+campo+" LIKE '%"+criterio+"%'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            while(res.next()){
               // datos.add(new Asiento(res.getInt("cAvion"),res.getInt("nAsiento"),res.getString("estado")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }

    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
