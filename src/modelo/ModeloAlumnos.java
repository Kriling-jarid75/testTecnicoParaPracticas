
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Garci
 */
public class ModeloAlumnos implements Comparable<ModeloAlumnos> { //se crean los getters and setters

    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String grupo;

    public ModeloAlumnos() {
    }//termina el constructor vacio

    public ModeloAlumnos(String nombre, String apellido, int edad, String genero, String grupo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.grupo = grupo;
    }//termina el contructor lleno

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {//metodo para imprimir todo en una sola linea

        return "alumnos{" + "apellido=" + apellido + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", grupo=" + grupo + '}';
    }//termina el toString

    @Override
    public int compareTo(ModeloAlumnos o) { //metodo para comprar los apellido y acomodarlos alfabeticamente
        return this.getApellido().compareTo(o.getApellido());
    }//termina el comparteTo 

}//termina la clase de Alumno
