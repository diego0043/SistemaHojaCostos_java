package sistemahojacostos;

import java.sql.ResultSet;

public class Insumos {
    //instanciar un objeto
    Conexion cn = new Conexion();

    public void insertar(int codigoInsumo, String descripcion, String precioUnitario, String codigoUnidad, String codigoCategoria) {
        cn.UID("INSERT INTO insumos(codigo,descripcion,tipo,unidad,precioUnitario) VALUES('" + codigoInsumo + "','" + descripcion + "','" + precioUnitario + "','" + codigoUnidad + "','" + codigoCategoria + "')");
    }

    public void modificar(int codigoInsumo, String descripcion, double precioUnitario, String codigoUnidad, int codigoCategoria) {
        cn.UID("UPDATE insumos SET descripcion='" + descripcion + "',precioUnitario='" + precioUnitario 
                + "',codigoUnidad='" + codigoUnidad+ "',codigoCategoria='" + codigoCategoria + "' WHERE codigoInsumo=" + codigoInsumo);
    }
    public void eliminar(String codigoUnidad) {
        cn.UID("DELETE FROM unidades WHERE codigoUnidad='" + codigoUnidad + "' ");
    }

    public ResultSet buscar(String codigoInsumo) {
        return (cn.getValores("SELECT * FROM insumos WHERE codigo='" + codigoInsumo + "'"));
    }

    public ResultSet busca(String descripcion) {
        return (cn.getValores("SELECT * FROM insumos WHERE descripcion ='" + descripcion + "'"));
    }
    
    
    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(codigo) FROM insumos"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(codigo) FROM insumos"));
    }

    public ResultSet llenarTabla() {
        return (cn.getValores("SELECT codigoUnidad,unidad FROM unidades"));
    }
    
    public ResultSet llenarInsumos(int tipo) {
        return (cn.getValores("SELECT * FROM insumos WHERE tipo='"+tipo+"'"));
    }
    
     public ResultSet llenarInsumos2(String codigo) {
        return (cn.getValores("SELECT * FROM insumos WHERE codigo='"+codigo+"'"));
    }
    
     public ResultSet verificar(){
    return (cn.getValores("SELECT * FROM insumos;"));
    }
    
}

