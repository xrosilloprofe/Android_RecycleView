package es.ieslavereda.android_recycleview;

public class Profesion {
    private int img;
    private String nombre;


    public Profesion(String nombre, int img){
        this.nombre = nombre;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
