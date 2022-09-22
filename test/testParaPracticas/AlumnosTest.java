/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testParaPracticas;

import controlador.ControladorAlumnos;
import java.util.ArrayList;
import modelo.ModeloAlumnos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Garci
 */
public class AlumnosTest {

    public AlumnosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of buscarPorGrupo method, of class ControladorAlumnos. Testing del
     * metodo buscarPorGrupo de la clase ControladorAlumnos
     * Testing en general
     */
    @Test
    public void testBuscarPorGrupo() throws Exception {
        System.out.println("buscarPorGrupo");
        String grupoDelAlumno = "A";
        ControladorAlumnos instance = new ControladorAlumnos();
        instance.buscarPorGrupo(grupoDelAlumno);

        if (grupoDelAlumno.equalsIgnoreCase("F")) {
            System.err.println("Error al mostrar el grupo");
        } else {
            System.out.println("Todo correcto");
        }
    }//end testing testBuscarPorGrupo

    /*
     *Test of mostrarPorEdad method, of class ControladorAlumnos. Testing del
     * metodo mostrarPorEdad of la clase ControlAlumnos
     */
    @Test
    public void testMostrarPorEdad() throws Exception {
        System.out.println("mostrarPorEdad");
        //Edad de los jovenes es de 18,19,20,21,22 y 23
        int edadDelAlumno = 23;
        ControladorAlumnos instance = new ControladorAlumnos();

        if (edadDelAlumno <= 17 || edadDelAlumno >= 24) {
            System.err.println("No encontramos jovenes de esa edad!!");
        } else {

            instance.mostrarPorEdad(edadDelAlumno);
        }
    }//end testing testMostrarPorEdad
    
    /**
     * Test of mostrarPorApellido method, of class ControladorAlumnos. Testing
     * del metodo mostrarPorEdad of la clase ControlAlumnos
     *
     */
    @Test
    public void testMostrarPorApellido() throws Exception {
        System.out.println("mostrarPorApellido");
        String apellidoDelAlumno = "Aguilar";
        ControladorAlumnos instance = new ControladorAlumnos();

        if (apellidoDelAlumno.equalsIgnoreCase("GARCIA")) {
            instance.mostrarPorApellido(apellidoDelAlumno);

        } else {
            System.err.println("El apellido no se encuentra!!");
        }
    }//end testing testMostrarPorApellido

     /**
     * Test of mostrarPorGeneroF method, of class ControladorAlumnos.
     *
     */
    @Test
    public void testMostrarPorGeneroF() throws Exception {
        System.out.println("mostrarPorGeneroF");
        String porGenero = "F";
        ControladorAlumnos instance = new ControladorAlumnos();
        if(porGenero.equalsIgnoreCase("M")) {
              instance.mostrarPorGeneroF();
        }else{
            System.err.println("No se encontraron mujeres");
        }
      
    }
    
    
    
    
    /**
     * Test of leerExcel method, of class ControladorAlumnos. Testing del metodo
     * leerExcel de la clase ControlAlumnos
     */
    /*@Test
    public void testLeerExcel() throws Exception {
        System.out.println("leerExcel");
        ControladorAlumnos instance = new ControladorAlumnos();
        instance.leerExcel();
    }*/
    /**
     * Test of mostrarPorGeneroM method, of class ControladorAlumnos.
     *
     */
    /*@Test
    public void testMostrarPorGeneroM() throws Exception {
        System.out.println("mostrarPorGeneroM");
        ControladorAlumnos instance = new ControladorAlumnos();
        instance.mostrarPorGeneroM(); // TODO review

    }*/
    
    /**
     * Test of dataExcel method, of class ControladorAlumnos.
     */
    /*@Test
    public void testDataExcel() throws Exception {
        System.out.println("dataExcel");
        ControladorAlumnos instance = new ControladorAlumnos();
        ArrayList<ModeloAlumnos> expResult = null;
        ArrayList<ModeloAlumnos> result = instance.dataExcel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
