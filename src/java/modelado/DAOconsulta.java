
package modelado;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import uml.Aerolinea;
import uml.Avion;
import uml.Reserva;
import uml.Tarifa;
import uml.Vuelo;
import uml.objRusuario;

public class DAOconsulta {
    conexion db = new conexion();
    
    public List<objRusuario> filtarInfoVuelo(int campo){
        List<objRusuario> datos = new ArrayList<objRusuario>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT *, (avion.nPasajeros- (SELECT COUNT(*) FROM avion, reserva WHERE reserva.cAvion=avion.idAvion AND avion.cAerolinea=1)) AS 'disponibles' FROM tarifas, aerolinea, avion WHERE tarifas.id="+campo+" AND tarifas.cAvion=avion.idAvion AND avion.cAerolinea=aerolinea.idAerolinea";
        //String query ="SELECT *, (avion.nPasajeros- (SELECT COUNT(*) FROM avion, reserva WHERE reserva.cAvion=avion.idAvion AND avion.cAerolinea=1)) AS 'disponibles' FROM tarifas, aerolinea, avion WHERE tarifas.cAerolinea=aerolinea.idAerolinea AND avion.cAerolinea=aerolinea.idAerolinea AND avion.idAvion="+campo+"";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            //Aerolinea aerolinea = new Aerolinea();
            
            while(res.next()){
                // datos.add(new objRusuario(res.getInt("id"), res.getString("nombre"),res.getString("cOrigen"),res.getString("cDestino"),res.getTimestamp("fSalida"),res.getTimestamp("fLlegada"),res.getDouble("precio"),res.getInt("idAvion"),res.getInt("nPasajeros"),res.getInt("disponibles")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
    
    public String crearReserva(int idTarifa, int cedulaUsu){
        DAOReserva daoR = new DAOReserva();
        DAOVuelo daoV = new DAOVuelo();
        Reserva res = new Reserva();
        Vuelo v = new Vuelo();
        List<objRusuario> datos = new ArrayList<objRusuario>();
        datos = filtarInfoVuelo(idTarifa);
        for(objRusuario b : datos){
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
            
            daoV.insertar(v);
            daoR.insertar(res);
        }
        return "Se creo una reserva";
    }
    
    public boolean verificar(int idtarifa, int idusuario){
        Connection conn;
        Statement pst1 = null;
        Statement pst2 = null;
        Statement pst3 = null;
        
        ResultSet res1 = null;
        ResultSet res2 = null;
        ResultSet res3 = null;
        
        String query1="SELECT edad FROM usuario WHERE cc="+idusuario+"";
        String query2="SELECT v.fSalida, v.hSalida FROM vuelo v, tarifa t, reserva r, usuario u WHERE v.idVuelo=t.cVuelo AND t.idTarifa=r.cTarifa AND r.cUsuario="+idusuario+"";
        String query3="SELECT v.fSalida, v.hSalida FROM vuelo v, tarifa t WHERE v.idVuelo=t.cVuelo AND t.idTarifa="+idtarifa+"";
        boolean resultado = false;
        
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            res1 = pst1.executeQuery(query1);
            res2 = pst2.executeQuery(query2);
            res3 = pst3.executeQuery(query3);
            
            while(res1.next()){
                 if(res1.getInt(1)>=18){}
            }
            
            if(res1.getInt(1)>=18){
                while(res2.next()){
                    if((res2.getString(1)==res3.getString(1)) && (res2.getString(2)==res3.getString(2))){
                        resultado = true;
                    }
                    else{
                        resultado = false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public List<objRusuario> listarReservas(int idusuario){
        List<objRusuario> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet res;
        String query = "SELECT ar.nombre ,v.idVuelo, v.cAvion, r.idAsiento, v.cOrigen, v.cDestino, v.fSalida, v.fLlegada, v.hSalida, v.hLlegada, t.costo, r.idReserva FROM aerolinea ar, avion av, vuelo v, tarifa t, reserva r WHERE v.idVuelo=t.cVuelo AND v.cAvion=av.idAvion AND av.cAerolinea=ar.idAerolinea AND t.idTarifa=r.cTarifa AND r.cUsuario="+idusuario+"";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContrasena());
            
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();

            while(res.next()){
                 datos.add(new objRusuario(res.getString("nombre"),res.getInt("idVuelo"),res.getInt("cAvion"),res.getInt("idAsiento"),res.getString("cOrigen"),res.getString("cDestino"),res.getDate("fSalida"),res.getDate("fLlegada"),res.getTime("hSalida"),res.getTime("hLlegada"),res.getDouble("costo"),res.getInt("idReserva")));
            }
            pst.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {}
        return datos;
    }
}
