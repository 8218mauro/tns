package uml;

public class Usuario {
    private int cc;
    private String nombres;
    private String apellidos;
    private int edad;
    private String correo;

    public Usuario() {
    }

    public Usuario(int cc, String nombres, String apellidos, int edad, String correo) {
        this.cc = cc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
}

