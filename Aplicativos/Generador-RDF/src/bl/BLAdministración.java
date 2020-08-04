package bl;

import dat.dataAdministracion;
import java.sql.SQLException;
import java.util.ArrayList;
import principal.Publicacion;
import java.sql.ResultSet;
import principal.Afiliacion;
import principal.Articulo;
import principal.Autor;
import principal.Pais;
import principal.PalabrasClave;
import principal.Publicacion;
import principal.Tipo_Afiliacion;

/**
 *
 * @author Febre
 */
public class BLAdministración {

    dataAdministracion data = new dataAdministracion();

    public ArrayList<Publicacion> consultarPublicacion() throws SQLException, ClassNotFoundException {
        ArrayList<Publicacion> lstPublicacion = new ArrayList<>();

        ResultSet rs = data.ConsultarPublicacion();
        //ResultSet rs = data.ConsultarArticuloPablasClave();

        while (rs.next()) {

            // Artículo
            int id_publicacion = rs.getInt("id_articulo");
            String tituloPublicacion = rs.getString("titulo");
            String doi = rs.getString("doi");
            int anio = rs.getInt("anio");
            String resumenPublicacion = rs.getString("resumen");
            String url = rs.getString("url");
            Articulo articuloObj = new Articulo(id_publicacion, tituloPublicacion, doi, anio, resumenPublicacion, url);

            // Autor
            int id_autor = rs.getInt("id_autor");
            String nombre_autor = rs.getString("nombre_autor");
            String correo = rs.getString("correo");
            Autor autorObj = new Autor(id_autor, nombre_autor, correo);

            // Pais
            int id_pais = rs.getInt("id_pais");
            String nombre_pais = rs.getString("nombre_pais");
            Pais paisObj = new Pais(id_pais, nombre_pais);

            // Tipo Afiliacion
            int id_tipoafiliacion = rs.getInt("id_tipoafiliacion");
            String nombre_tipoafiliacion = rs.getString("nombre_tipoafiliacion");
            Tipo_Afiliacion tipo_afiliacionObj = new Tipo_Afiliacion(id_tipoafiliacion, nombre_tipoafiliacion);

            // Afiliacion
            int id_afiliacion = rs.getInt("id_afiliacion");
            String nombre_afiliacion = rs.getString("nombre_afiliacion");
            String ciudad = rs.getString("ciudad");
            Afiliacion afiliacionObj = new Afiliacion(id_afiliacion, nombre_afiliacion, ciudad, paisObj, tipo_afiliacionObj);

            // Palabras Clave
            //int id_palabrasclave = rs.getInt("id_palabras_clave");
            String palabras_clave = rs.getString("palabras_clave");
            PalabrasClave palabras_claveObj = new PalabrasClave(palabras_clave);

            //PalabrasClave pcObj = new PalabrasClave(id_palabrasclave, palabras_clave);
            Publicacion publicacionObj = new Publicacion(id_autor, tituloPublicacion, doi,
                    anio, resumenPublicacion, url, id_publicacion, nombre_autor, correo,
                    id_afiliacion, nombre_afiliacion, ciudad, id_pais, nombre_pais, id_tipoafiliacion,
                    nombre_tipoafiliacion, palabras_clave
            );

            lstPublicacion.add(publicacionObj);
        }
        return lstPublicacion;

    }

}
