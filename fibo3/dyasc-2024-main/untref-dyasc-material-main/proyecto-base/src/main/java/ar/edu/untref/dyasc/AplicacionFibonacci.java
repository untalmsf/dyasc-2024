package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AplicacionFibonacci {

    public static void main(String[] args) {
        try {
            Argumentos argumentos = procesarArgumentos(args);
            List<Integer> serieFibonacci = generarFibonacci(argumentos.n);
            String resultado = modoDeOperacion(serieFibonacci, argumentos.modo);

            if (argumentos.nombreArchivo != null) {
                escribirArchivo(argumentos.nombreArchivo, resultado);
                System.out.println("fibo<" + argumentos.n + "> guardado en " + argumentos.nombreArchivo);
            } else {
                imprimirFibonacci(resultado, argumentos.orientacion, argumentos.direccion);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    private static Argumentos procesarArgumentos(String[] args) {
        String orientacion = "h";
        String direccion = "d";
        String nombreArchivo = null;
        String modo = "l";
        int n = 0;

        for (String arg : args) {
            if (arg.startsWith("-o=")) {
                String opcion = arg.substring(3);
                if (opcion.length() == 2) {
                    orientacion = opcion.substring(0, 1);
                    direccion = opcion.substring(1, 2);

                    if ((!orientacion.equals("h") && !orientacion.equals("v")) ||
                        (!direccion.equals("d") && !direccion.equals("i"))) {
                        throw new IllegalArgumentException("Opciones inválidas.");
                    }
                } else {
                    throw new IllegalArgumentException("Opciones inválidas.");
                }
            } else if (arg.startsWith("-f=")) {
                nombreArchivo = arg.substring(3);
            } else if (arg.startsWith("-m=")) {
                modo = arg.substring(3);
                if (!modo.equals("l") && !modo.equals("s")) {
                    throw new IllegalArgumentException("Modo inválido.");
                }
            } else {
                try {
                    n = Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Número inválido: " + arg);
                }
            }
        }

        return new Argumentos(orientacion, direccion, nombreArchivo, modo, n);
    }

    private static List<Integer> generarFibonacci(int n) {
        List<Integer> serieFibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            serieFibonacci.add(a);
            int temp = a;
            a = b;
            b = temp + b;
        }
        return serieFibonacci;
    }

    private static String modoDeOperacion(List<Integer> serieFibonacci, String modo) {
        if (modo.equals("s")) {
            int suma = serieFibonacci.stream().mapToInt(Integer::intValue).sum();
            return "fibo<" + serieFibonacci.size() + "s>: " + suma;
        } else {
            return "fibo<" + serieFibonacci.size() + ">: " + String.join(" ", serieFibonacci.stream().map(Object::toString).toArray(String[]::new));
        }
    }

    private static void escribirArchivo(String nombreArchivo, String contenido) throws IOException {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(contenido);
        }
    }

    private static void imprimirFibonacci(String resultado, String orientacion, String direccion) {
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

    // Clase interna para almacenar los argumentos procesados
    private static class Argumentos {
        String orientacion;
        String direccion;
        String nombreArchivo;
        String modo;
        int n;

        Argumentos(String orientacion, String direccion, String nombreArchivo, String modo, int n) {
            this.orientacion = orientacion;
            this.direccion = direccion;
            this.nombreArchivo = nombreArchivo;
            this.modo = modo;
            this.n = n;
        }
    }
}
