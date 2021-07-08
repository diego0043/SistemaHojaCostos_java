package sistemahojacostos;

import java.sql.ResultSet;

public class InsumosxHoja {

    //instanciar un objeto
    Conexion cn = new Conexion();

    public void insertar(int codigoHoja, int codigoInsumo, double cantidad) {
        cn.UID("INSERT INTO insumosporHoja(codigoHoja,codigo,cantidad) VALUES('" + codigoHoja + "','" + codigoInsumo + "','" + cantidad + "')");
    }

    public void modificar(int codigoHoja, int codigoInsumo, double cantidad) {
        //cn.UID("UPDATE unidades SET unidad='" + unidad + "'");
        cn.UID("UPDATE insumosxhoja SET cantidad='" + cantidad + "' WHERE codigoHoja='" + codigoHoja + "' && codigoInsumo='" + codigoInsumo + "';");
    }

    public void modificar(String cantidad, String codigoHoja, String codigo) {
        //cn.UID("UPDATE unidades SET unidad='" + unidad + "'");
        cn.UID("UPDATE insumosPorHoja SET cantidad='" + cantidad + "' WHERE codigoHoja='" + codigoHoja + "' && codigo='" + codigo + "';");
    }

    public void eliminar(String codigoHoja) {
        cn.UID("DELETE FROM insumosPorHoja WHERE codigoHoja='" + codigoHoja + "' ");
    }

    public void eliminarInsumo(String codigoHoja, String codigo) {
        cn.UID("DELETE FROM insumosPorHoja WHERE codigoHoja='" + codigoHoja + "' && codigo='" + codigo + "';");

    }

    public ResultSet buscar(String codigoUnidad) {
        return (cn.getValores("SELECT * FROM insumosPorHoja WHERE codigoUnidad='" + codigoUnidad + "'"));
    }

    public ResultSet contarRegistros() {
        return (cn.getValores("SELECT COUNT(codigoHoja) FROM hojas"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getValores("SELECT MAX(codigoHoja) FROM hojas"));
    }

    public ResultSet llenarTabla(int codigoHoja) {
        return (cn.getValores("SELECT insumosporhoja.codigoHoja, insumosporHoja.codigo, insumos.descripcion, insumos.precioUnitario, insumosporhoja.cantidad, insumos.precioUnitario*insumosporhoja.cantidad FROM insumosporHoja INNER JOIN insumos ON insumosporHoja.codigo=insumos.codigo WHERE codigoHoja='" + codigoHoja + "' "));
    }

    public ResultSet llenarInsumos() {
        return (cn.getValores("SELECT * FROM insumosporhoja "));
    }
    
     public ResultSet llenarInsumos2(String codHoja) {
        return (cn.getValores("SELECT * FROM insumosporhoja WHERE codigoHoja='"+codHoja+"';"));
    }

    public ResultSet buscar2(String codHoja, String codInsumo) {
        return (cn.getValores("SELECT * FROM insumosPorHoja WHERE codigoHoja='" + codHoja + "' && codigo='" + codInsumo + "';"));

    }

    public ResultSet BusquedaProgresiva(String buscado, String criterio) {
        if (criterio.equals("codigoHoja")) {
            return (cn.getValores("SELECT insumosxhoja.codigoHoja, insumosxHoja.codigoInsumo, insumos.descripcion, insumos.precio, insumosxhoja.cantidad, insumos.precio*insumosxhoja.cantidad FROM insumosxHoja INNER JOIN insumos ON insumosxHoja.codigoInsumo=insumos.codigoInsumo WHERE codigoHoja LIKE'%" + buscado + "%';"));
        } else {
            return (cn.getValores("SELECT insumosxhoja.codigoHoja, insumosxhoja.codigoInsumo, insumos.descripcion, insumos.precioUnitario, insumosxhoja.cantidad, insumos.PrecioUnitario*insumosxhoja.cantidad FROM insumosxHoja INNER JOIN insumos ON insumosxHoja.codigoInsumo=insumos.codigoInsumo WHERE descripcion LIKE'%" + buscado + "%';"));
        }

    }
}
