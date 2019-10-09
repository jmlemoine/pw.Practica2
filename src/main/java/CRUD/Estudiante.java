package CRUD;

public class Estudiante {

    int matricula;
    String nombre;
    String apellido;
    String telefono;

    public Estudiante(int matricula, String nombre, String apellido, String telefono){
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;

    }

    public Estudiante(){
        this.matricula = 0;
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";

    }


}
