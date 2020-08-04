/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author ferna
 */
public class Articulo {

    private int id_articulo;
    private String fuente;
    private String idioma;
    private String titulo;
    private String doi;
    private int anio;
    private String resumen;
    private String url;

    public Articulo(int id_articulo, String fuente, String idioma, String titulo, String doi, int anio, String resumen, String url) {
        this.id_articulo = id_articulo;
        this.fuente = fuente;
        this.idioma = idioma;
        this.titulo = titulo;
        this.doi = doi;
        this.anio = anio;
        this.resumen = resumen;
        this.url = url;
    }

    public Articulo(int id_articulo, String titulo, String doi, int anio, String resumen, String url) {
        this.id_articulo = id_articulo;
        this.titulo = titulo;
        this.doi = doi;
        this.anio = anio;
        this.resumen = resumen;
        this.url = url;
    }
    
    

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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

}
