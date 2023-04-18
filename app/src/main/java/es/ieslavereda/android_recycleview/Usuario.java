package es.ieslavereda.android_recycleview;

import java.io.Serializable;
import java.util.Comparator;

public class Usuario implements Serializable {

    public static final Comparator<Usuario> SORT_BY_NAME = (u1, u2) -> {
        if(u1.apellidos.compareToIgnoreCase(u2.getApellidos()) == 0)
            return u1.nombre.compareToIgnoreCase(u2.getNombre());
        return u1.apellidos.compareToIgnoreCase(u2.getApellidos());
    };

    public static final Comparator<Usuario> SORT_BY_JOB = (u1, u2) -> {
        Profesion p1, p2;
        p1 = ProfesionRepository.getInstance().getProfesionByImage(u1.idProfesion);
        p2 = ProfesionRepository.getInstance().getProfesionByImage(u2.idProfesion);
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    };

    private String nombre;
    private String apellidos;
    private int idProfesion;

    public Usuario(String nombre, String apellidos, int idProfesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idProfesion = idProfesion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getIdProfesion() {
        return idProfesion;
    }
}
