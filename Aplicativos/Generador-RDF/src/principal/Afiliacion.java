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
public class Afiliacion {

    private int id_afiliacion;
    private String nombre_afiliacion;
    private String ciudad_afiliacion;
    private Pais id_pais;
    private Tipo_Afiliacion id_tipoafiliacion;

    public Afiliacion(int id_afiliacion, String nombre_afiliacion, String ciudad_afiliacion, Pais id_pais, Tipo_Afiliacion id_tipoafiliacion) {
        this.id_afiliacion = id_afiliacion;
        this.nombre_afiliacion = nombre_afiliacion;
        this.ciudad_afiliacion = ciudad_afiliacion;
        this.id_pais = id_pais;
        this.id_tipoafiliacion = id_tipoafiliacion;
    }

    public Afiliacion(String nombre_afiliacion, String ciudad_afiliacion, Pais id_pais, Tipo_Afiliacion id_tipoafiliacion) {
        this.nombre_afiliacion = nombre_afiliacion;
        this.ciudad_afiliacion = ciudad_afiliacion;
        this.id_pais = id_pais;
        this.id_tipoafiliacion = id_tipoafiliacion;
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

    public Pais getId_pais() {
        return id_pais;
    }

    public void setId_pais(Pais id_pais) {
        this.id_pais = id_pais;
    }

    public Tipo_Afiliacion getId_tipoafiliacion() {
        return id_tipoafiliacion;
    }

    public void setId_tipoafiliacion(Tipo_Afiliacion id_tipoafiliacion) {
        this.id_tipoafiliacion = id_tipoafiliacion;
    }

}
