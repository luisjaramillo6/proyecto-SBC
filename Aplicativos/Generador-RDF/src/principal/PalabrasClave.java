package principal;

public class PalabrasClave {

    private int id_palabraclave;
    private String nombre_palabraclave;

    public PalabrasClave(int id_palabraclave, String nombre_palabraclave) {
        this.id_palabraclave = id_palabraclave;
        this.nombre_palabraclave = nombre_palabraclave;
    }

    public PalabrasClave(String nombre_palabraclave) {
        this.nombre_palabraclave = nombre_palabraclave;
    }

    public int getId_palabraclave() {
        return id_palabraclave;
    }

    public void setId_palabraclave(int id_palabraclave) {
        this.id_palabraclave = id_palabraclave;
    }

    public String getNombre_palabraclave() {
        return nombre_palabraclave;
    }

    public void setNombre_palabraclave(String nombre_palabraclave) {
        this.nombre_palabraclave = nombre_palabraclave;
    }

}
