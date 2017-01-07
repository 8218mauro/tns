package uml;

public class Tarifa {
    private int idTarifa;
    private int cVuelo;
    private double costo;

    public Tarifa() {
    }

    public Tarifa(int idTarifa, int cVuelo, double costo) {
        this.idTarifa = idTarifa;
        this.cVuelo = cVuelo;
        this.costo = costo;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getcVuelo() {
        return cVuelo;
    }

    public void setcVuelo(int cVuelo) {
        this.cVuelo = cVuelo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
