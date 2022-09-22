/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ModeloAlumnos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Garci
 */
public class ControladorAlumnos {

    public void leerExcel() throws IOException {

        String SEPARATOR = ",";
        BufferedReader br = null;
        ArrayList<ModeloAlumnos> alumnos = new ArrayList<ModeloAlumnos>();

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Garci\\Documents\\NetBeansProjects\\testTecnicoParaPracticas\\datos.csv"));
           //aqui va la ruta del archivo para que lo pueda leer en mi caso yo lo tengo en esta ruta
            String line = br.readLine();

            while (null != line) {

                String[] cortarString = line.split(SEPARATOR);
                ModeloAlumnos students = new ModeloAlumnos();
                // Pongo los atributos al objeto "students"
                students.setNombre(cortarString[0]);
                students.setApellido(cortarString[1]);
                students.setEdad(Integer.parseInt(cortarString[2]));
                students.setGenero(cortarString[3]);
                students.setGrupo(cortarString[4]);
                alumnos.add(students);
                Collections.sort(alumnos);
                line = br.readLine();
            }//termina while

            Iterator<ModeloAlumnos> itralumnos = alumnos.iterator();
            while (itralumnos.hasNext()) {
                ModeloAlumnos alumnosEnSalon = itralumnos.next();

                System.out.println(alumnosEnSalon.toString());
            }//termina while

        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e2) {
            }
        }//termina el try

        System.out.println("... Hay " + alumnos.size() + " alumnos en lista  ...");

    }//termina el metodo leerExcel

    public ArrayList<ModeloAlumnos> dataExcel() throws IOException { //leeo el archivo de excel y regreso el dataExcel para usarlo
        String SEPARATOR = ",";
        BufferedReader br = null;
        ArrayList<ModeloAlumnos> alumnos = new ArrayList<ModeloAlumnos>();//creo un arraylist 

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Garci\\Documents\\NetBeansProjects\\testTecnicoParaPracticas\\datos.csv"));
            String line = br.readLine();//lectura del arcivo

            while (null != line) {

                String[] cortarString = line.split(SEPARATOR);
                ModeloAlumnos students = new ModeloAlumnos();
                // Pongo los atributos al objeto "students"
                students.setNombre(cortarString[0]);
                students.setApellido(cortarString[1]);
                students.setEdad(Integer.parseInt(cortarString[2]));
                students.setGenero(cortarString[3]);
                students.setGrupo(cortarString[4]);
                alumnos.add(students);
                Collections.sort(alumnos);//Coloca a los alumnos alfabeticamente
                line = br.readLine();
            }//termina while            

        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e2) {

            }
        }//termina el try

        return alumnos;
    }//termina el metodo data_excel

    public void buscarPorGrupo(String grupoDelAlumno) throws IOException {//metodo para buscar un grupo solicitando un dato
       
        ArrayList<ModeloAlumnos> data_grupo = new ArrayList<ModeloAlumnos>();
        int num_alum = 0;//varibla contador por grupoo
        int num_m = 0;//contador para generoM
        int num_f = 0;//contador para generoF

        ArrayList<ModeloAlumnos> data_excel = dataExcel();//OBTENGO VALORES DEL EXCEL
        Collections.sort(data_excel);
        for (int i = 0; i < data_excel.size(); i++) {//RECORRER EL EXCEL
            ModeloAlumnos alumnosEnSalon = data_excel.get(i);//LO ASIGNO A UNA VARIBLE 
            if (alumnosEnSalon.getGrupo().equals(grupoDelAlumno.toUpperCase())) {
                ModeloAlumnos alumnos_grupo = new ModeloAlumnos(alumnosEnSalon.getNombre(), alumnosEnSalon.getApellido(), alumnosEnSalon.getEdad(), alumnosEnSalon.getGenero(), alumnosEnSalon.getGrupo());
                data_grupo.add(alumnos_grupo);
                if (alumnosEnSalon.getGenero().equals("M")) {
                    num_m++;
                }//termina if de comparacion por genero M

                if (alumnosEnSalon.getGenero().equals("F")) {
                    num_f++;
                }//termina if de comparacion por genero F
                num_alum++;//contador goblal
            }
        }//termina form
        
        if (num_alum > 0) {//comparacion del total de los alumnos 
            double por_f = (double) (num_f * 100) / num_alum;
            double por_h = (double) (num_m * 100) / num_alum;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Total de alumnos del grupo: " + grupoDelAlumno + " (" + num_alum + ")");//total de alumnos
            System.out.println("Total de alumnos que son Mujeres: " + num_f + " " + df.format(por_f) + "%");//porcentajes
            System.out.println("Total de alumnos que son Hombres: " + num_m + " " + df.format(por_h) + "%");//porcentajes

            for (int i = 0; i < data_grupo.size(); i++) {
                ModeloAlumnos alumnosEnSalon = data_grupo.get(i);
                System.out.println(alumnosEnSalon.toString());
            }//termina for de impresion
        } else {

            System.err.println("No se encontraron datos!!");
        }//termina if de comparacion

    }

    public void mostrarPorGeneroF() throws IOException {//metodo para mostrar por genero F

        ArrayList<ModeloAlumnos> data_genero = new ArrayList<ModeloAlumnos>();
        Collections.sort(data_genero);
        ArrayList<ModeloAlumnos> data_excel = dataExcel();

        for (int i = 0; i < data_excel.size(); i++) {
            ModeloAlumnos alumnosEnSalon = data_excel.get(i);
            if (alumnosEnSalon.getGenero().equals("F")) {//valido lio que tengo en el arraylist con el genero de M
                ModeloAlumnos alumnos_grupo = new ModeloAlumnos(alumnosEnSalon.getNombre(), alumnosEnSalon.getApellido(), alumnosEnSalon.getEdad(), alumnosEnSalon.getGenero(), alumnosEnSalon.getGrupo());
                data_genero.add(alumnos_grupo);
            }//tertmina if de validadacion 
        }//termina for de lectura de excel
        
        for (int i = 0; i < data_genero.size(); i++) {
            ModeloAlumnos alumnosEnSalon = data_genero.get(i);
            System.out.println(alumnosEnSalon.toString());
        }//termina for de impresion
    }//termina metodo mostrarPorGeneroF

    public void mostrarPorGeneroM() throws IOException {//metodo para mostrar por generoM
       
        ArrayList<ModeloAlumnos> data_genero = new ArrayList<ModeloAlumnos>();//lectura de excel mediante arraylist
        ArrayList<ModeloAlumnos> data_excel = dataExcel();//creacion de objetios

        for (int i = 0; i < data_excel.size(); i++) {
            ModeloAlumnos alumnosEnSalon = data_excel.get(i);
            if (alumnosEnSalon.getGenero().equals("M")) {//cse compara lo que tiene el arraylist con lo genero
                ModeloAlumnos alumnos_grupo = new ModeloAlumnos(alumnosEnSalon.getNombre(), alumnosEnSalon.getApellido(), alumnosEnSalon.getEdad(), alumnosEnSalon.getGenero(), alumnosEnSalon.getGrupo());
                data_genero.add(alumnos_grupo);
            }
        }//termina for 

        for (int i = 0; i < data_genero.size(); i++) {
            ModeloAlumnos alumnosEnSalon = data_genero.get(i);
            System.out.println(alumnosEnSalon.toString());//imprimo mis valores
        }//termina for de impresion
    }//termina metodo mostrarPorGenero

    public void mostrarPorEdad(int edadDelAlumno) throws IOException {//metodo por mostrar edad por paso de parametros

        ArrayList<ModeloAlumnos> data_edad = new ArrayList<ModeloAlumnos>();//se lee el arryalist del excel 
        ArrayList<ModeloAlumnos> data_excel = dataExcel();//aqui creo otro objeto y mediante otro arraylist
        for (int i = 0; i < data_excel.size(); i++) {//RECORRER EL EXCEL
            ModeloAlumnos alumnosEnSalon = data_excel.get(i);//LO ASIGNO A UNA VARIBLE 
            if (alumnosEnSalon.getEdad() >= edadDelAlumno) {
                ModeloAlumnos alumnos_grupo = new ModeloAlumnos(alumnosEnSalon.getNombre(), alumnosEnSalon.getApellido(), alumnosEnSalon.getEdad(), alumnosEnSalon.getGenero(), alumnosEnSalon.getGrupo());
                data_edad.add(alumnos_grupo);
            }
        }//termina dor de lectura del excel

        if (edadDelAlumno >= 18 && edadDelAlumno <24) {//validio la edad
            for (int i = 0; i < data_edad.size(); i++) {
                ModeloAlumnos alumnosEnSalon = data_edad.get(i);
                System.out.println(alumnosEnSalon.toString());
            }//termina el for de impresion
        } else {
            System.err.println("No encontramos esa edad!!!");
        }//termina el else
    }//terimina metodo mostrarPorEdad

    public void mostrarPorApellido(String apellidoDelAlumno) throws IOException {//metodo para mostrar los apellidos

        ArrayList<ModeloAlumnos> data_apellidos = new ArrayList<ModeloAlumnos>();//leeo el arraylist mediante la clase alumnos con getters and setters
        int num_alum = 0;
        ArrayList<ModeloAlumnos> data_excel = dataExcel();//OBTENGO VALORES DEL EXCEL
        for (int i = 0; i < data_excel.size(); i++) {//RECORRER EL EXCEL
            ModeloAlumnos alumnosEnSalon = data_excel.get(i);//LO ASIGNO A UNA VARIBLE 
            if (alumnosEnSalon.getApellido().equals(apellidoDelAlumno.toUpperCase())) {//comparamos el dato ingresado con el que leer del array
                ModeloAlumnos alumnos_grupo = new ModeloAlumnos(alumnosEnSalon.getNombre(), alumnosEnSalon.getApellido(), alumnosEnSalon.getEdad(), alumnosEnSalon.getGenero(), alumnosEnSalon.getGrupo());
                data_apellidos.add(alumnos_grupo);
                num_alum++;
            }
        }//termina for de lectura del excel

        if (num_alum > 0) {

            System.out.println("Total de alumnos que hay con el mismo apellido: (" + num_alum + ")");

            for (int i = 0; i < data_apellidos.size(); i++) {
                ModeloAlumnos alumnosEnSalon = data_apellidos.get(i);
                System.out.println(alumnosEnSalon.toString());
            }//termina el for de impresion de los datos del array con respecto al if
        } else {
            System.err.println("No se encontraron datos!!");
        }//termina else
    }//terina metodo mostrarPorApellido
}//termina la clase ControladorAlumnos 
