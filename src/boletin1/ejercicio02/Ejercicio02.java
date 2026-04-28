package boletin1.ejercicio02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {

        int suma = 0;
        double media;
        int num;
        int cont = 0;

        try {
            Scanner scanner = new Scanner(new FileReader("src\\boletin1\\ejercicio02\\Enteros.txt"));
            while (scanner.hasNextInt()) {
                num = scanner.nextInt();
                suma += num;
                cont++;
            }

            media = suma / cont;
            System.out.println("Suma = " + suma);
            System.out.println("Media = " + media);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("El fichero: " + e.getMessage());
        }

    }

}