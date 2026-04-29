package boletin2.ejercicio07;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Ejercicio07 {

    private static final String FICHERO = "src\\boletin2\\ejercicio07\\Clientes.txt";
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cargarClientes();

        int opcion;

        do {
            System.out.println("\n1. Alta cliente");
            System.out.println("2. Baja cliente");
            System.out.println("3. Listar clientes");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> alta();
                case 2 -> baja();
                case 3 -> listar();
            }

        } while (opcion != 0);

        guardarClientes();
    }

    private static void alta() {

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                System.out.println("Ya existe.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());

        System.out.print("Saldo: ");
        double saldo = Double.parseDouble(sc.nextLine());

        clientes.add(new Cliente(dni, nombre, fecha, saldo));
        clientes.sort(Comparator.comparing(Cliente::getDni));
    }

    private static void baja() {

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        clientes.removeIf(c -> c.getDni().equals(dni));
    }

    private static void listar() {

        double total = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;

        for (Cliente c : clientes) {
            System.out.println(c.getDni() + " " + c.getNombre() + " " +
                    c.getSaldo() + " Edad: " + c.getEdad());

            total += c.getSaldo();
            max = Math.max(max, c.getSaldo());
            min = Math.min(min, c.getSaldo());
        }

        if (!clientes.isEmpty()) {
            System.out.println("Saldo medio: " + (total / clientes.size()));
            System.out.println("Máximo: " + max);
            System.out.println("Mínimo: " + min);
        }
    }

    private static void cargarClientes() {

        File f = new File(FICHERO);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");

                clientes.add(new Cliente(
                        p[0],
                        p[1],
                        LocalDate.parse(p[2]),
                        Double.parseDouble(p[3])
                ));
            }

        } catch (IOException e) {
            System.out.println("Error carga: " + e.getMessage());
        }
    }

    private static void guardarClientes() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {

            for (Cliente c : clientes) {
                bw.write(c.toFileString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error guardado: " + e.getMessage());
        }
    }
}