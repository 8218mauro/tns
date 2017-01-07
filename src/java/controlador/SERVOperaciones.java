package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uml.*;
import modelado.*;
/**
 *
 * @author MAURICIO
 */
public class SERVOperaciones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String tabla = "";
            String operacion = request.getParameter("operacion");
            
            
            try {
                if("filtrarPorHorario".equals(operacion)){
                    String origen = request.getParameter("origen");
                    String destino = request.getParameter("destino");
                    Date fecha = Date.valueOf(request.getParameter("fecha"));
                    
                    DAOVuelo dao = new DAOVuelo();
                    List<Vuelo> datos = new ArrayList<>();
                    tabla +="<tr><th>Id Vuelo</th><th>Codigo de Avion</th><th>C. Origen</th><th>C. Destino</th><th>F. Salida</th><th>F. Llegada</th><th>Hora de salida</th><th>Hora de Llegada</th><th>A disponibles</th><th>Asientos libres</th><tr>";
                        datos=dao.consultarVueloPorFecha(origen, destino, fecha);
                        for (Vuelo t : datos){
                            DAOTarifas ta = new DAOTarifas();
                            Tarifa tar = new Tarifa();
                            tar = ta.consultarTarifaPorVuelo(t.getIdVuelo());
                            tabla+="<tr><td>"+t.getIdVuelo()+"</td><td>"+t.getcAvion()+"</td><td>"+t.getcOrigen()+"</td><td>"+t.getcDestino()+"</td><td>"+t.getfSalida()+"</td><td>"+t.getfLlegada()+"</td><td>"+t.gethSalida()+"</td><td>"+t.gethLlegada()+"</td><td>"+t.getaDisponibles()+"</td><td><button class='Estado btn btn-primary' data-idtarifa='"+tar.getIdTarifa()+"' data-idavion='"+t.getcAvion()+"' name='Estado' value='"+t.getIdVuelo()+"'>Estado</button></td></tr>";
                        }
                        out.print(tabla);
                        
                }else if("filtrarPorCosto".equals(operacion)){
                    String origen = request.getParameter("origen");
                    String destino = request.getParameter("destino");
                    Date fecha = Date.valueOf(request.getParameter("fecha"));
                    double costoInicial =Double.parseDouble(request.getParameter("costoInicial"));
                    double costoFinal = Double.parseDouble(request.getParameter("costoFinal"));
                    DAOVuelo dao = new DAOVuelo();
                    List<Vuelo> datos = new ArrayList<>();
                    tabla +="<tr><th>Id Vuelo</th><th>Codigo de Avion</th><th>C. Origen</th><th>C. Destino</th><th>F. Salida</th><th>F. Llegada</th><th>Hora de salida</th><th>Hora de Llegada</th><th>A disponibles</th><th>Costo</th><th>Ver asientos disponibles</th><tr>";
                        datos=dao.consultarVueloPorPrecio(origen, destino, fecha, costoInicial, costoFinal);
                        for (Vuelo v : datos){
                            DAOTarifas ta = new DAOTarifas();
                            Tarifa tar = new Tarifa();
                            tar = ta.consultarTarifaPorVuelo(v.getIdVuelo());
                            tabla+="<tr><td>"+v.getIdVuelo()+"</td><td>"+v.getcAvion()+"</td><td>"+v.getcOrigen()+"</td><td>"+v.getcDestino()+"</td><td>"+v.getfSalida()+"</td><td>"+v.getfLlegada()+"</td><td>"+v.gethSalida()+"</td><td>"+v.gethLlegada()+"</td><td>"+v.getaDisponibles()+"</td><td>"+tar.getCosto()+"</td><td><button class='Estado btn btn-primary' data-idtarifa='"+tar.getIdTarifa()+"' data-idavion='"+v.getcAvion()+"' name='Estado' value='"+v.getIdVuelo()+"'>Estado</button></td></tr>";
                        }
                        out.print(tabla);
                        
                }else if("reserva".equals(operacion)){
                    String resultado = "";
                    HttpSession sesion = request.getSession();
                    
                    int cedula = (Integer) sesion.getAttribute("usuario");
                    int asiento = Integer.parseInt(request.getParameter("asiento"));
                    int idtarifa = Integer.parseInt(request.getParameter("tarifa"));
                    
                    /*DAOconsulta con = new DAOconsulta();
                    boolean res = con.verificar(idtarifa, cedula);
                    if(res==true){
                        resultado = "No puedes reservar";
                    }else if(res=false){
                        resultado = "Puedes reservar";
                    }*/
                    
                    try {
                        DAOReserva dao = new DAOReserva();
                        Reserva r = new Reserva();
                        
                        r.setcUsuario(cedula);
                        r.setIdAsiento(asiento);
                        r.setcTarifa(idtarifa);
                        
                        resultado = dao.insertar(r);
                        
                    } catch (Exception e) {}
                    out.print(resultado);
                    
                }else if("mostrarAdisponibles".equals(operacion)){
                    String resultado;
                    int idtarifa = Integer.parseInt(request.getParameter("idtarifa"));
                    int idvuelo = Integer.parseInt(request.getParameter("idvuelo"));
                    
                    DAOAsiento dao = new DAOAsiento();
                    List<Asiento> datos = new ArrayList<>();
                    tabla +="<tr><th>Codigo de Avion</th><th>Id Asiento</th><th>Accion</th><tr>";
                        datos=dao.listarAsientosDisponibles(idvuelo, idtarifa);
                        for (Asiento a : datos){
                            tabla+="<tr><td>"+a.getcAvion()+"</td><td>"+a.getIdAsiento()+"</td><td><button id='Reservar' class='btn btn-primary' name='Reservar' data-cavion='"+a.getcAvion()+"' data-asiento='"+a.getIdAsiento()+"'>Reservar</button></td></tr>";
                        }
                        out.print(tabla);
                        
                }else if("consultaReservas".equals(operacion)){
                    String resultado;
                    HttpSession sesion = request.getSession();
                    int cedula = (Integer) sesion.getAttribute("usuario");
                    
                    
                    DAOconsulta dao = new DAOconsulta();
                    List<objRusuario> datos = new ArrayList<>();
                    tabla +="<tr><th>Nombre de aerolinea</th><th>Id Vuelo</th><th>Id avion</th><th>Nro de Asiento</th><th>Ciudad Origen</th><th>Ciudad Destino</th><th>Fecha de salida</th><th>Fecha de llegada</th><th>Hora de salida</th><th>Hora de llegada</th><th>Costo</th><th>Id de reserva</th><tr>";
                        datos=dao.listarReservas(cedula);
                        for (objRusuario a : datos){
                            tabla+="<tr><td>"+a.getNomAerolinea()+"</td><td>"+a.getIdVuelo()+"</td><td>"+a.getIdAvion()+"</td><td>"+a.getCoAsiento()+"</td><td>"+a.getcOrigen()+"</td><td>"+a.getcDestino()+"</td><td>"+a.getfSalida()+"</td><td>"+a.getfLlegada()+"</td><td>"+a.gethSalisa()+"</td><td>"+a.gethLlegada()+"</td><td>"+a.getCosto()+"</td><td>"+a.getIdReserva()+"</td></tr>";
                        }
                        out.print(tabla);
                }
            } catch (Exception e) {
            }   
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
