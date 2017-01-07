/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import uml.Aerolinea;
import uml.Reserva;
import uml.Tarifa;

/**
 *
 * @author MAURICIO
 */
public class DAOTarifas implements operaciones{
    conexion db = new conexion();
    
    @Override
    public String insertar(Object obj) {
        DAOReserva dao = new DAOReserva();
        Reserva res = new Reserva();
        
        List<Reserva> datos = new ArrayList<>();
        
        for(Reserva r : datos){
           /* v.setCoAvion(b.getcAvion());
            v.setcOrigen(b.getcOrigen());
            v.setcDestino(b.getcDestino());
            v.setfLlegada(b.getFllegada());
            v.setfSalida(b.getfSalida());
            v.setaDisponibles(b.getaDisponibles());
            
            res.setcUsuario(cedulaUsu);
            res.setcAvion(b.getcAvion());
            res.setcVuelo(0);
            res.setCosto(cedulaUsu);
            res.setcSilla(cedulaUsu);*/
        }
        return "Se creo una reserva";
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Tarifa consultarTarifaPorVuelo(int cVuelo){
        Tarifa datos = new Tarifa();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT t.idTarifa, t.cVuelo, t.costo FROM tarifa t WHERE t.cVuelo="+cVuelo+"";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            if(res.next()){
                datos = new Tarifa(res.getInt("idTarifa") ,res.getInt("cVuelo"),res.getDouble("costo"));
            }
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
 
    @Override
    public List<Tarifa> listar() {
        List<Tarifa> datos = new ArrayList<Tarifa>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM tarifas, aerolinea WHERE tarifas.cAerolinea=aerolinea.idAerolinea and tarifas.costo >= '' and tarifas.costo <= '' ";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            
            Aerolinea aerolinea = new Aerolinea();
            aerolinea.setIdAerolinea(res.getInt("cAerolinea"));
            aerolinea.setNombre("nombre");
            
            while(res.next()){
                 //datos.add(new Tarifa(aerolinea,res.getString("cOrigen"),res.getString("cDestino"),res.getTimestamp("fSalida"),res.getTimestamp("fLlegada"),res.getDouble("precio")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        
        return datos;
    }
    
    public List<Tarifa> filtrarPorFecha(Timestamp campo) {
        
        List<Tarifa> datos = new ArrayList<Tarifa>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM  tarifas, aerolinea WHERE tarifas.cAerolinea=aerolinea.idAerolinea AND tarifas.fSalida>='"+campo+"'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            //Aerolinea aerolinea = new Aerolinea();
            
            while(res.next()){
                //aerolinea.setIdAerolinea(res.getInt("cAerolinea"));
                //aerolinea.setNombre(res.getString("nombre"));
                 //datos.add(new Tarifa(res.getInt("id"),new Aerolinea(res.getInt("cAerolinea"),res.getString("nombre")),res.getString("cOrigen"),res.getString("cDestino"),res.getTimestamp("fSalida"),res.getTimestamp("fLlegada"),res.getDouble("precio"),res.getInt("cAvion")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        
        return datos;
    }
    
     public List<Tarifa> filtrarPorCosto(String costoInicial, String costoFinal) {
        
        List<Tarifa> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT * FROM tarifas, aerolinea WHERE tarifas.cAerolinea=aerolinea.idAerolinea AND tarifas.precio>='"+costoInicial+"'  and  tarifas.precio<='"+costoFinal+"'";
        
        try {
            
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            //Aerolinea aerolinea = new Aerolinea();
            
            while(res.next()){
                //aerolinea.setIdAerolinea(res.getInt("cAerolinea"));
                //aerolinea.setNombre(res.getString("nombre"));
                 //datos.add(new Tarifa(res.getInt("id"),new Aerolinea(res.getInt("cAerolinea"),res.getString("nombre")),res.getString("cOrigen"),res.getString("cDestino"),res.getTimestamp("fSalida"),res.getTimestamp("fLlegada"),res.getDouble("precio"),res.getInt("cAvion")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
