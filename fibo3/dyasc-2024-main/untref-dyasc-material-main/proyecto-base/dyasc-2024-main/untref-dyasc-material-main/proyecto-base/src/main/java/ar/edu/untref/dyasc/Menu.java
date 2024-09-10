package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Menu {

    public static String modoDeOperacion(List<Integer> serieFibonacci, String modo) {
        if (modo.equals("s")) {
            int suma = serieFibonacci.stream().mapToInt(Integer::intValue).sum();
            return "fibo<" + serieFibonacci.size() + "s>: " + suma;
        } else {
            return "fibo<" + serieFibonacci.size() + ">: " + String.join(" ", serieFibonacci.stream().map(Object::toString).toArray(String[]::new));
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) throws IOException {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(contenido);
        }
    }

    public static void imprimirFibonacci(String resultado, String orientacion, String direccion) {
        String[] partes = resultado.split(": ");
        String cabecera = partes[0];
        String[] elementosFibonacci = partes.length > 1 ? partes[1].split(" ") : new String[0];

        if (direccion.equals("i")) {
            Collections.reverse(List.of(elementosFibonacci));
        }

        if (orientacion.equals("h")) {
            System.out.println(cabecera + ": " + String.join(" ", elementosFibonacci));
        } else if (orientacion.equals("v")) {
            System.out.println(cabecera + ":");
            for (String elemento : elementosFibonacci) {
                System.out.println(elemento);
            }
        } else {
            System.out.println("Orientación inválida.");
        }
    }
}
