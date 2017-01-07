package uml;

public class Avion {
    private int idAvion;
    private int nPasajeros;
    private int cAerolinea;

    public Avion() {
    }

    public Avion(int idAvion, int nPasajeros, int cAerolinea) {
        this.idAvion = idAvion;
        this.nPasajeros = nPasajeros;
        this.cAerolinea = cAerolinea;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public int getnPasajeros() {
        return nPasajeros;
    }

    public void setnPasajeros(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    public int getcAerolinea() {
        return cAerolinea;
    }

    public void setcAerolinea(int cAerolinea) {
        this.cAerolinea = cAerolinea;
    }
    
}
