package uml;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Vuelo {
  
    private int idVuelo;
    private int cAvion;
    private String cOrigen;
    private String cDestino;
    private Date fSalida;
    private Date fLlegada;
    private Time hSalida;
    private Time hLlegada;
    private int aDisponibles;

    public Vuelo() {
    }

    public Vuelo(int idVuelo, int cAvion, String cOrigen, String cDestino, Date fSalida, Date fLlegada, Time hSalida, Time hLlegada, int aDisponibles) {
        this.idVuelo = idVuelo;
        this.cAvion = cAvion;
        this.cOrigen = cOrigen;
        this.cDestino = cDestino;
        this.fSalida = fSalida;
        this.fLlegada = fLlegada;
        this.hSalida = hSalida;
        this.hLlegada = hLlegada;
        this.aDisponibles = aDisponibles;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getcAvion() {
        return cAvion;
    }

    public void setcAvion(int cAvion) {
        this.cAvion = cAvion;
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

    public Time gethSalida() {
        return hSalida;
    }

    public void sethSalida(Time hSalida) {
        this.hSalida = hSalida;
    }

    public Time gethLlegada() {
        return hLlegada;
    }

    public void sethLlegada(Time hLlegada) {
        this.hLlegada = hLlegada;
    }

    public int getaDisponibles() {
        return aDisponibles;
    }

    public void setaDisponibles(int aDisponibles) {
        this.aDisponibles = aDisponibles;
    }

    
    
}
