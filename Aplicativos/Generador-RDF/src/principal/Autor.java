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
public class Autor {

    private int id_autor;
    private String nombre_autor;
    private String correo;

    public Autor() {
    }

    public Autor(int id_autor, String nombre_autor, String correo) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
        this.correo = correo;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
