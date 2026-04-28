package boletin1.ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fecha;

        int tempMin;

        int tempMax;

        int opcion;

        System.out.println("1. Registra nueva temperatura");
        System.out.println("2. Mostrar historial de registros");
        System.out.println("3. Salir");
        opcion = sc.nextInt();

        while (opcion != 3) {

            switch (opcion) {
                case 1 -> {

                    System.out.println("Introduce la temperatura máxima");
                    tempMax = sc.nextInt();
                    System.out.println("Introduce la temperatura mínima");
                    tempMin = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduce la fecha");
                    fecha = sc.nextLine();

                    try {
                        BufferedWriter bw = new BufferedWriter(
                                new FileWriter("src\\boletin1\\ejercicio08\\Temperatura.txt", true));

                        bw.write(fecha + ", " + tempMax + ", " + tempMin);
                        bw.newLine();

                        bw.flush();
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("Error al abrir el archivo para escribir");
                    }
                }
                case 2 -> {
                    try {
                        BufferedReader br = new BufferedReader(
                                new FileReader("src\\boletin1\\ejercicio08\\Temperatura.txt"));

                        String linea;

                        linea = br.readLine();

                        while (linea != null) {
                            System.out.println(linea);

                            linea = br.readLine();
                        }

                        br.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("El archivo no existe");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo");
                    }
                }
                case 3 -> {
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion incorrecta");
            }
            System.out.println("1. Registra nueva temperatura");
            System.out.println("2. Mostrar historial de registros");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
        }
        sc.close();
    }

}