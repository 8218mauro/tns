package uml;

public class Reserva {
    private int idReserva;
    private int cUsuario;
    private int idAsiento;
    private int cTarifa;
    
    public Reserva() {
    }

    public Reserva(int idReserva, int cUsuario, int idAsiento, int cTarifa) {
        this.idReserva = idReserva;
        this.cUsuario = cUsuario;
        this.idAsiento = idAsiento;
        this.cTarifa = cTarifa;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(int cUsuario) {
        this.cUsuario = cUsuario;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getcTarifa() {
        return cTarifa;
    }

    public void setcTarifa(int cTarifa) {
        this.cTarifa = cTarifa;
    }

    
}
