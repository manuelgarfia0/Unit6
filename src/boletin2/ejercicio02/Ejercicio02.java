package boletin2.ejercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio02 {
    private static final String FICHERO = "src\\boletin2\\ejercicio02\\Firmas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> firmas = mostrarFirmas();

        System.out.println("Libro de Firmas:");
        mostrarFirmas(firmas);

        System.out.println("Introduce un nuevo nombre:");
        String nuevoNombre = scanner.nextLine().trim();

        if (firmas.contains(nuevoNombre)) {
            System.out.println("El nombre ya existe en el libro de firmas.");
        } else {
            firmas.add(nuevoNombre);
            guardarFirmas(firmas);
            System.out.println("¡Nombre añadido con éxito!");
        }

        scanner.close();
    }

    private static List<String> mostrarFirmas() {
        List<String> firmas = new ArrayList<>();
        File fichero = new File(FICHERO);

        if (fichero.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                String linea;
                while ((linea = br.readLine()) != null) {
                    firmas.add(linea.trim());
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }

        return firmas;
    }

    private static void mostrarFirmas(List<String> firmas) {
        if (firmas.isEmpty()) {
            System.out.println("El libro de firmas está vacío.");
        } else {
            for (String firma : firmas) {
                System.out.println(firma);
            }
        }
    }

    private static void guardarFirmas(List<String> firmas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
            for (String firma : firmas) {
                bw.write(firma);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}