package boletin1.ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03 {

    public static void main(String[] args) {
        double suma = 0;
        int sumaEdad = 0;
        double sumaAltura = 0;
        double mediaEdad;
        double mediaAltura;
        double cont = 0;
        String nombre = "";
        int edad;
        double altura;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\ejercicio03\\Alumnos.txt"));

            String linea = br.readLine();
            while (linea != null) {
                String datos[] = linea.split(" ");
                nombre = datos[0];
                edad = Integer.parseInt(datos[1]);
                altura = Double.parseDouble(datos[2]);

                nombre += nombre + " ";
                sumaEdad += edad;
                sumaAltura += altura;

                cont++;

                linea = br.readLine();
            }

            mediaEdad = sumaEdad / cont;
            mediaAltura = sumaAltura / cont;
            System.out.println(nombre);
            System.out.println("Media edades = " + mediaEdad);
            System.out.println("Media alturas = " + mediaAltura);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }

}