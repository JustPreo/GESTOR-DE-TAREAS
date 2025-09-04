/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestortareas;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class GESTORTAREAS {

    static File file = new File("Tareas.txt");//Esto se va a poner en el src me imagino
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    static int cTareas = 0;
    
    //El formato sera cTareas. [] nombre 
    private static void agregarT(String nombre) throws IOException {
        cTareas++;
        FileWriter w = new FileWriter("Tareas.txt");
        w.write(cTareas+".[]"+nombre);// en teoria seria 1.[]Nombre
        

    }

    private static void mostrarT() throws IOException {
        FileReader r = new FileReader("Tareas.txt");

    }

    //Completar tareas seria tipo conseguir el texto entero y conseguir el numero y reemplazar esos chars con eso 
    private static void completarT() throws IOException {

    }

    private static void initArchivo() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void main(String[] args) {
        try {
            while (true) {
                initArchivo();
                System.out.println("GESTOR DE TAREAS ");
                System.out.println("====================");
                System.out.println("1. Agregar tarea ");
                System.out.println("2. Mostrar tareas");
                System.out.println("3. Completar tarea ");
                System.out.println("4. Salir");
                System.out.println("Seleccionar una opcion:");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresa la nueva tarea:");
                        String nTarea = scanner.next();
                        agregarT(nTarea);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;

                }

            }
        } catch (IOException e) {
            System.out.println("Problema de archivos womp womp");
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero , no una letra o simbolo");
        }

    }

}
