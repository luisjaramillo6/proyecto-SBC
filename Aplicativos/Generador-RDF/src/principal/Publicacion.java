package principal;

import java.util.ArrayList;

public class Publicacion {

    private int id_publicacion;
    private String titulo;
    private String doi;
    private int anio;
    private String resumen;
    private String url;
    private int id_autor;
    private String nombreAutor;
    private String correo;
    private int id_afiliacion;
    private String nombre_afiliacion;
    private String ciudad_afiliacion;
    private int id_pais;
    private String nombre_pais;
    private int id_tipoafiliacion;
    private String nombre_tipoafiliacion;
    private String palabras_clave;

    public Publicacion(int id_publicacion, String titulo, String doi, int anio, String resumen, String url, int id_autor, String nombreAutor, String correo, int id_afiliacion, String nombre_afiliacion, String ciudad_afiliacion, int id_pais, String nombre_pais, int id_tipoafiliacion, String nombre_tipoafiliacion, String palabras_clave) {
        this.id_publicacion = id_publicacion;
        this.titulo = titulo;
        this.doi = doi;
        this.anio = anio;
        this.resumen = resumen;
        this.url = url;
        this.id_autor = id_autor;
        this.nombreAutor = nombreAutor;
        this.correo = correo;
        this.id_afiliacion = id_afiliacion;
        this.nombre_afiliacion = nombre_afiliacion;
        this.ciudad_afiliacion = ciudad_afiliacion;
        this.id_pais = id_pais;
        this.nombre_pais = nombre_pais;
        this.id_tipoafiliacion = id_tipoafiliacion;
        this.nombre_tipoafiliacion = nombre_tipoafiliacion;
        this.palabras_clave = palabras_clave;
    }

    public int getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(int id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_afiliacion() {
        return id_afiliacion;
    }

    public void setId_afiliacion(int id_afiliacion) {
        this.id_afiliacion = id_afiliacion;
    }

    public String getNombre_afiliacion() {
        return nombre_afiliacion;
    }

    public void setNombre_afiliacion(String nombre_afiliacion) {
        this.nombre_afiliacion = nombre_afiliacion;
    }

    public String getCiudad_afiliacion() {
        return ciudad_afiliacion;
    }

    public void setCiudad_afiliacion(String ciudad_afiliacion) {
        this.ciudad_afiliacion = ciudad_afiliacion;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public int getId_tipoafiliacion() {
        return id_tipoafiliacion;
    }

    public void setId_tipoafiliacion(int id_tipoafiliacion) {
        this.id_tipoafiliacion = id_tipoafiliacion;
    }

    public String getNombre_tipoafiliacion() {
        return nombre_tipoafiliacion;
    }

    public void setNombre_tipoafiliacion(String nombre_tipoafiliacion) {
        this.nombre_tipoafiliacion = nombre_tipoafiliacion;
    }

    public String getPalabras_clave() {
        return palabras_clave;
    }

    public void setPalabras_clave(String palabras_clave) {
        this.palabras_clave = palabras_clave;
    }

}
