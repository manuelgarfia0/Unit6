package boletin1.ejercicio06;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio06 {

    public static void main(String[] args) {
        List<Integer> lista = leeNumeros();

        Collections.sort(lista);

        escribeLista(lista);
    }

    public static List<Integer> leeNumeros() {
        List<Integer> listaNumeros = new ArrayList<>();
        String fichero = "src\\boletin1\\ejercicio06\\NumerosDesordenados.txt";

        try {
            Scanner scanner = new Scanner(new FileReader(fichero));

            int numero;

            while (scanner.hasNextInt()) {
                numero = scanner.nextInt();

                listaNumeros.add(numero);
            }
        } catch (Exception e) {
            System.out.println("No se encuentra el fichero");
        }
        return listaNumeros;
    }

    public static void escribeLista(List<Integer> lista) {
        String fichero = "src\\boletin1\\ejercicio06\\NumerosOrdenados.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

            for (int numero : lista) {
                bw.write(String.valueOf(numero));
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}