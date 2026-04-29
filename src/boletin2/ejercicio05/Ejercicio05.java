package boletin2.ejercicio05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio05 {

    public static void main(String[] args) {

        String f1 = "src\\boletin2\\ejercicio05\\Archivo1.txt";
        String f2 = "src\\boletin2\\ejercicio05\\Archivo2.txt";

        try (BufferedReader br1 = new BufferedReader(new FileReader(f1));
             BufferedReader br2 = new BufferedReader(new FileReader(f2))) {

            String l1, l2;
            int linea = 1;

            while (true) {
                l1 = br1.readLine();
                l2 = br2.readLine();

                if (l1 == null && l2 == null) {
                    System.out.println("Los archivos son iguales.");
                    break;
                }

                if (l1 == null || l2 == null) {
                    System.out.println("Archivos distintos en la línea " + linea);
                    break;
                }

                int max = Math.min(l1.length(), l2.length());

                for (int i = 0; i < max; i++) {
                    if (l1.charAt(i) != l2.charAt(i)) {
                        System.out.println("Diferencia en línea " + linea + ", carácter " + (i + 1));
                        return;
                    }
                }

                if (l1.length() != l2.length()) {
                    System.out.println("Diferencia en línea " + linea + ", carácter " + (max + 1));
                    return;
                }

                linea++;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}