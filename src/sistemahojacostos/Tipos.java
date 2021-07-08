package sistemahojacostos;

import java.sql.ResultSet;

public class Tipos {

    //instanciar un objeto
    Conexion cn = new Conexion();

    public ResultSet llenarTipos() {
        return (cn.getValores("SELECT * FROM tipos"));
    }

    public ResultSet buscar(String cod) {
        return (cn.getValores("SELECT * FROM tipos WHERE tipo='" + cod + "'"));
    }

    public ResultSet EncontrarTipo(String descripcion) {
        return (cn.getValores("SELECT * FROM tipos WHERE descripcion='" + descripcion + "'"));
    }

}
