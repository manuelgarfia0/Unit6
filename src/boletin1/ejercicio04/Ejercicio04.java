package boletin1.ejercicio04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\Ejercicio04\\texto.txt"));
            Scanner scanner = new Scanner(System.in);
            String linea;
            do {
                System.out.println("Introduce una frase o palabra: ");
                linea = scanner.next();
                bw.write(linea);
                bw.newLine();
            } while (!linea.equalsIgnoreCase("fin"));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}