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
public class Tipo_Afiliacion {

    private int id_tipoafiliacion;
    private String nombre_tipoafiliacion;

    public Tipo_Afiliacion(int id_tipoafiliacion, String nombre_tipoafiliacion) {
        this.id_tipoafiliacion = id_tipoafiliacion;
        this.nombre_tipoafiliacion = nombre_tipoafiliacion;
    }

    public Tipo_Afiliacion(String nombre_tipoafiliacion) {
        this.nombre_tipoafiliacion = nombre_tipoafiliacion;
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

}
