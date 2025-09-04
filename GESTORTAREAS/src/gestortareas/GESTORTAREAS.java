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
    static String tareas[] = new String[10000];//Porque arraylist me bugeaba

    static int cTareas = 0;

    //El formato sera cTareas. [] nombre 
    private static void agregarT(String nombre) throws IOException {
        tareas[cTareas] = nombre;
        cTareas++;
        FileWriter w = new FileWriter("Tareas.txt");
        StringBuilder b = new StringBuilder();
        b.append(mostrarT());
        b.append(cTareas + ".[]" + nombre);
        w.write(b.toString());// en teoria seria 1.[]Nombre
        w.close();

    }

    private static String mostrarT() throws IOException {
        char[] ar;

        StringBuilder texto;
        FileReader r = new FileReader("Tareas.txt");
        ar = new char[(int) file.length()];
        texto = new StringBuilder();
        r.read(ar);
        for (int i = 0; i < file.length(); i++) {
            texto.append(ar[i]);
        }
        int c = 0;
        int total = 0;
        while ((c = r.read()) != -1) {
            if (c == '\n') {
                tareas[total++] = texto.toString();
                texto.setLength(0);
            } else {
                texto.append((char) c);
            }
        }

        return texto.toString();

    }

    //Completar tareas seria tipo conseguir el texto entero y conseguir el numero y reemplazar esos chars con eso 
    private static void completarT(int numTarea) throws IOException {
        String ar = mostrarT();
        for (int i = 0; i < ar.length(); i++) {

        }

    }

    private static void initArchivo() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void main(String[] args) throws IOException {
        try {

            while (true) {
                System.out.println("Archivo tiene length:" + file.length());
                initArchivo();
                System.out.println("GESTOR DE TAREAS ");
                System.out.println("====================");
                System.out.println("1. Agregar tarea ");
                System.out.println("2. Mostrar tareas");
                System.out.println("3. Completar tarea ");
                System.out.println("4. Salir");
                System.out.println("Seleccionar una opcion:");
                int opcion = scanner.nextInt();
                try {
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa la nueva tarea:");
                            String nTarea = scanner.next();
                            agregarT(nTarea);
                            break;
                        case 2:
                            System.out.println(mostrarT());
                            break;
                        case 3:
                            System.out.println("Ingrese la tarea a completar");
                            int numTarea = scanner.nextInt();
                            completarT(numTarea);
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                            break;

                    }
                } catch (IOException e) {
                    System.out.println("Problema de archivos womp womp");
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un numero , no una letra o simbolo");
                }

            }

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

}
