/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Acciones.metodos;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Garci
 */
public class TestParaPracticas {

    public static void main(String[] args) throws IOException {

        mostrarMenu();//mando a llamar el metodo del menu

    }//termina el main

    public static void mostrarMenu() throws IOException {//se crea el menu principal 
        int opc = 0;
        Scanner read = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        boolean exit = false;
        String grupoDelAlumno;
        int edadDelAlumno;
        String apellidoDelAlumno;
        String seguir;

        while (!exit) {
            System.out.println("*******Bienvenido al Menú de Alumnos********\n"
                    + "1.- Mostrar Todos los alumnos\n"
                    + "2.- Buscar un Grupo\n"
                    + "3.- Mostrar Por Género Femenino\n"
                    + "4.- Mostrar Por Género Masculino\n"
                    + "5.- Mostrar Por Edad\n"
                    + "6.- Mostrar Por Apellido\n"
                    + "7.- Salir del programa");
            try {
                System.out.println("<>Seleccione una opción<>");
                opc = read.nextInt();

                switch (opc) {//se crea el switch para las opciones
                    case 1:
                        System.out.println("Presione ENTER para continuar...");
                        try {
                            seguir = teclado.nextLine();
                            if (seguir.isEmpty()) {
                                metodos elExcel = new metodos();
                                elExcel.leerExcel();
                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                        } catch (IOException e) {
                        }
                        break;
                    case 2:

                        System.out.println("Presione ENTER para continuar...");
                        try {
                            seguir = teclado.nextLine();
                            if (seguir.isEmpty()) {
                                System.out.println("--Ingrese el GRUPO a buscar--\n"
                                        + "Las opciones son: [A],[B],[C],[D]");
                                grupoDelAlumno = read.next();
                                metodos buscarEn = new metodos();
                                buscarEn.buscarPorGrupo(grupoDelAlumno);
                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                        } catch (IOException e) {
                        }

                        break;
                    case 3:

                        System.out.println("Press Enter key to continue...");
                        try {
                            seguir = teclado.nextLine();

                            if (seguir.isEmpty()) {
                                metodos mostrarF = new metodos();
                                mostrarF.mostrarPorGeneroF();
                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                        } catch (IOException e) {
                        }
                        break;
                    case 4:
                        System.out.println("Presione ENTER para continuar...");
                        try {
                            seguir = teclado.nextLine();

                            if (seguir.isEmpty()) {
                                metodos mostrarM = new metodos();
                                mostrarM.mostrarPorGeneroM();
                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                        } catch (IOException e) {
                        }
                        break;
                    case 5:

                        System.out.println("Presione ENTER para continuar...");
                        try {
                            seguir = teclado.nextLine();

                            if (seguir.isEmpty()) {
                                System.out.println("--Ingrese la EDAD a buscar--");
                                edadDelAlumno = read.nextInt();
                                metodos buscarEdadEn = new metodos();
                                buscarEdadEn.mostrarPorEdad(edadDelAlumno);
                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                        } catch (IOException e) {
                        }

                        break;
                    case 6:

                        System.out.println("Presione ENTER para continuar...");
                        try {
                            seguir = teclado.nextLine();

                            if (seguir.isEmpty()) {
                                System.out.println("--Ingrese el APELLIDO a buscar--");
                                apellidoDelAlumno = read.next();
                                metodos buscarApellidoEn = new metodos();
                                buscarApellidoEn.mostrarPorApellido(apellidoDelAlumno);

                            } else {
                                System.err.println("No presionaste ENTER, Inténtalo de nuevo!!");
                            }

                            break;
                        } catch (IOException e) {
                        }//termina el try
                    case 7:
                        exit = true;
                        System.out.println("Hasta luego!!! :D ");
                        break;
                    default:
                        System.err.println("Error. Opcion Incorrecta!!!, Intentélo de Nuevo");
                }//termina el sitch
            } catch (InputMismatchException e) {
                System.err.println("Error, Ingrese sólo números del 1 al 7, Intentélo de Nuevo");
                read.nextLine();
            }//termina el try
        }//terimina el while de opciones
    }//termina el metodo mostrar menu
}//termina la clase principal TestParaPracticas
