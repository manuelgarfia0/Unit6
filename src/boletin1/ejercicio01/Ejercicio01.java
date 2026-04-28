package boletin1.ejercicio01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {

        double suma = 0;
        double media;
        double num;
        int cont = 0;

        try {
            Scanner scanner = new Scanner(new FileReader("src\\boletin1\\ejercicio01\\NumerosReales.txt"));
            while (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
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