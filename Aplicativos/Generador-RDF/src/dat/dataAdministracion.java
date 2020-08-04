package dat;

import com.mysql.jdbc.PreparedStatement;
import conexion.Conectar;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Febre
 */
public class dataAdministracion {

    Conectar con = new Conectar();

    public ResultSet ConsultarPublicacion() throws SQLException, ClassNotFoundException {

        PreparedStatement pst = (PreparedStatement) con.getConectar().prepareStatement("SELECT art.id_articulo , art.titulo, art.doi, art.anio, art.resumen, art.url, au.id_autor, au.nombre_autor, au.correo, afi.id_afiliacion, afi.nombre_afiliacion, afi.ciudad, ps.id_pais, ps.nombre_pais, tafi.id_tipoafiliacion, tafi.nombre_tipoafiliacion, GROUP_CONCAT(pc.nombre_palabraclave) AS palabras_clave FROM articulo art, autor au, articulo_autor a_a, afiliacion afi, paises ps, tipo_afiliacion tafi, palabras_clave pc, articulo_palabras_clave apc WHERE 1 = 1 AND au.id_autor = a_a.id_autor AND art.id_articulo = a_a.id_articulo AND afi.id_afiliacion = au.id_afiliacion AND afi.id_pais = ps.id_pais AND afi.id_tipo = tafi.id_tipoafiliacion AND pc.id_palabraclave = apc.idarticulo_palabraclave AND art.id_articulo = apc.id_articulo GROUP BY au.id_autor ORDER BY art.id_articulo;");
        ResultSet rs = pst.executeQuery();
        return rs;
    }

}
