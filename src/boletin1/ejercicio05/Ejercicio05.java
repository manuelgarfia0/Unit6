package boletin1.ejercicio05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio05 {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\ejercicio05\\Datos.txt", true));
            Scanner scanner = new Scanner(System.in);
            String nombre;
            int edad;

            System.out.println("Introduzca el nombre: ");
            nombre = scanner.nextLine();
            System.out.println("Introduzca la edad: ");
            edad = scanner.nextInt();

            bw.write(nombre + " " + edad);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}