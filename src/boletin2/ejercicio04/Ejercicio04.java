package boletin2.ejercicio04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        String input = "src\\boletin2\\ejercicio04\\Entrada.txt";
        String output = "src\\boletin2\\ejercicio04\\Salida.txt";
        String codec = "src\\boletin2\\ejercicio04\\Codec.txt";

        Map<Character, Character> mapa = cargarCodec(codec);

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                StringBuilder cifrada = new StringBuilder();

                for (char c : linea.toCharArray()) {
                    char lower = Character.toLowerCase(c);

                    if (mapa.containsKey(lower)) {
                        char nuevo = mapa.get(lower);
                        cifrada.append(Character.isUpperCase(c) ? Character.toUpperCase(nuevo) : nuevo);
                    } else {
                        cifrada.append(c);
                    }
                }

                bw.write(cifrada.toString());
                bw.newLine();
            }

            System.out.println("Fichero cifrado correctamente.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Map<Character, Character> cargarCodec(String fichero) {
        Map<Character, Character> mapa = new HashMap<>();

        try (Scanner sc = new Scanner(new File(fichero))) {

            String alfabeto = sc.nextLine().replace(" ", "");
            String cifrado = sc.nextLine().replace(" ", "");

            for (int i = 0; i < alfabeto.length(); i++) {
                mapa.put(alfabeto.charAt(i), cifrado.charAt(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró codec.txt");
        }

        return mapa;
    }
}