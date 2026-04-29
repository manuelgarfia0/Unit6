package boletin2.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio03 {

    private static final int LINEAS_POR_PAGINA = 24;

    public static void main(String[] args) {
        String fichero = "src\\boletin2\\ejercicio03\\Carta.txt";

        try (Scanner sc = new Scanner(new File(fichero))) {

            int contador = 0;

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                contador++;

                if (contador == LINEAS_POR_PAGINA) {
                    System.out.println("\n--- Pulsa ENTER para continuar ---");
                    new Scanner(System.in).nextLine();
                    contador = 0;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero: " + fichero);
        }
    }
}