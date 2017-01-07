package modelado;

import java.sql.Timestamp;
import java.util.List;

public interface operaciones {
    public String insertar(Object obj);
    public String eliminar(Object obj);
    public String modificar(Object obj);
    public List<?> listar();
    public List<?> filtrar(String campo, String criterio);
   
}
