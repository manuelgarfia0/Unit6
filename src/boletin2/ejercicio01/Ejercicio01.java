package boletin2.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        String nombreFichero = "src\\boletin2\\ejercicio01\\carta.txt";
        int caracteres = 0;
        int lineas = 0;
        int palabras = 0;

        try {
            Scanner scanner = new Scanner(new File(nombreFichero));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                lineas++;

                caracteres += linea.length();

                String[] palabrasLinea = linea.split(" ");
                palabras += palabrasLinea.length;
            }

            System.out.println("Número de líneas: " + lineas);
            System.out.println("Número de palabras: " + palabras);
            System.out.println("Número de caracteres: " + caracteres);
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombreFichero + " no se encontró.");
        }
    }
}