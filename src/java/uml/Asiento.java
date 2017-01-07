package uml;

public class Asiento {
    private int idAsiento;
    private int cAvion;

    public Asiento() {
    }

    public Asiento(int idAsiento, int cAvion) {
        this.idAsiento = idAsiento;
        this.cAvion = cAvion;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getcAvion() {
        return cAvion;
    }

    public void setcAvion(int cAvion) {
        this.cAvion = cAvion;
    }

    
   
}
