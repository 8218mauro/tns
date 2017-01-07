package uml;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class objRusuario {
    private String nomAerolinea;
    private int idVuelo;
    private int idAvion;
    private int coAsiento;
    private String cOrigen;
    private String cDestino;
    private Date fSalida;
    private Date fLlegada;
    private Time hSalisa;
    private Time hLlegada;
    private double costo;
    private int idReserva;

    public objRusuario() {
    }

    public objRusuario(String nomAerolinea, int idVuelo, int idAvion, int coAsiento, String cOrigen, String cDestino, Date fSalida, Date fLlegada, Time hSalisa, Time hLlegada, double costo, int idReserva) {
        this.nomAerolinea = nomAerolinea;
        this.idVuelo = idVuelo;
        this.idAvion = idAvion;
        this.coAsiento = coAsiento;
        this.cOrigen = cOrigen;
        this.cDestino = cDestino;
        this.fSalida = fSalida;
        this.fLlegada = fLlegada;
        this.hSalisa = hSalisa;
        this.hLlegada = hLlegada;
        this.costo = costo;
        this.idReserva = idReserva;
    }

    public String getNomAerolinea() {
        return nomAerolinea;
    }

    public void setNomAerolinea(String nomAerolinea) {
        this.nomAerolinea = nomAerolinea;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public int getCoAsiento() {
        return coAsiento;
    }

    public void setCoAsiento(int coAsiento) {
        this.coAsiento = coAsiento;
    }

    public String getcOrigen() {
        return cOrigen;
    }

    public void setcOrigen(String cOrigen) {
        this.cOrigen = cOrigen;
    }

    public String getcDestino() {
        return cDestino;
    }

    public void setcDestino(String cDestino) {
        this.cDestino = cDestino;
    }

    public Date getfSalida() {
        return fSalida;
    }

    public void setfSalida(Date fSalida) {
        this.fSalida = fSalida;
    }

    public Date getfLlegada() {
        return fLlegada;
    }

    public void setfLlegada(Date fLlegada) {
        this.fLlegada = fLlegada;
    }

    public Time gethSalisa() {
        return hSalisa;
    }

    public void sethSalisa(Time hSalisa) {
        this.hSalisa = hSalisa;
    }

    public Time gethLlegada() {
        return hLlegada;
    }

    public void sethLlegada(Time hLlegada) {
        this.hLlegada = hLlegada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
}
