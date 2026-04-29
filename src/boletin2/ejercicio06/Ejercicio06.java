package boletin2.ejercicio06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio06 {

    public static void main(String[] args) {

        String fichero = "src\\boletin2\\ejercicio06\\Deportistas.txt";

        String mayorEdad = "";
        String mayorPeso = "";
        String mayorAltura = "";

        int edadMax = -1;
        double pesoMax = -1;
        double alturaMax = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(" ");

                String nombre = datos[0] + " " + datos[1];
                int edad = Integer.parseInt(datos[2]);
                double peso = Double.parseDouble(datos[3]);
                double altura = Double.parseDouble(datos[4]);

                if (edad > edadMax) {
                    edadMax = edad;
                    mayorEdad = nombre;
                }

                if (peso > pesoMax) {
                    pesoMax = peso;
                    mayorPeso = nombre;
                }

                if (altura > alturaMax) {
                    alturaMax = altura;
                    mayorAltura = nombre;
                }
            }

            System.out.println("Mayor edad: " + mayorEdad);
            System.out.println("Mayor peso: " + mayorPeso);
            System.out.println("Mayor estatura: " + mayorAltura);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}