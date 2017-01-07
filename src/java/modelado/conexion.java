package modelado;

public class conexion {
    private String driver;
    private String url;
    private String usuario;
    private String contrasena;

    public conexion() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost/vuelos";
        this.usuario = "root";
        this.contrasena = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    
}
