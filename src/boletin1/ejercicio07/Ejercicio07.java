package boletin1.ejercicio07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio07 {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\ejercicio07\\Agenda.txt"));

            Scanner sc = new Scanner(System.in);

            // Mapa para guardar los contactos
            HashMap<String, Integer> agenda = new HashMap<>();

            String[] datos;

            String linea;

            int opcion;

            String nombre;

            int telf;

            linea = br.readLine();

            while (linea != null) {
                datos = linea.split(" ");

                nombre = datos[0];

                telf = Integer.parseInt(datos[1]);

                agenda.put(nombre, telf);

                linea = br.readLine();
            }
            System.out.println("1. Nuevo contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            sc.nextLine();

            while (opcion != 4) {

                switch (opcion) {
                    case 1 -> {
                        if (agenda.size() < 20) {
                            System.out.println("Introduce el nombre");
                            nombre = sc.nextLine();
                            System.out.println("Introduce el teléfono");
                            telf = sc.nextInt();
                            sc.nextLine();
                            agenda.put(nombre, telf);
                        } else {
                            System.out.println("La agenda ya tiene 20 contactos");
                        }
                    }
                    case 2 -> {
                        System.out.println("Introduce el nombre que quiere buscar");
                        nombre = sc.nextLine();

                        if (agenda.get(nombre) != null) {
                            System.out.println("El teléfono de " + nombre + " es: " + agenda.get(nombre));
                        } else {
                            System.out.println("No se ha encontrado ese nombre en la agenda");
                        }
                    }
                    case 3 -> {
                        System.out.println(agenda);
                    }
                    case 4 -> {

                        System.out.println("Saliendo...");

                    }
                    default -> System.out.println("Opción inválida");
                }

                System.out.println("1. Nuevo contacto");
                System.out.println("2. Buscar por nombre");
                System.out.println("3. Mostrar todos");
                System.out.println("4. Salir");
                opcion = sc.nextInt();
                sc.nextLine();
            }

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("src\\\\boletin1\\\\ejercicio07\\\\Agenda.txt"));

                for (String key : agenda.keySet()) {
                    Integer value = agenda.get(key);
                    bw.write(key + " " + value);
                    bw.newLine();
                }

                bw.flush();
                bw.close();

                System.out.println("Se han guardado los datos con exito");
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo para escribir");
            }

            sc.close();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e1) {
            System.out.println("Error al leer el archivo");
        }
    }
}