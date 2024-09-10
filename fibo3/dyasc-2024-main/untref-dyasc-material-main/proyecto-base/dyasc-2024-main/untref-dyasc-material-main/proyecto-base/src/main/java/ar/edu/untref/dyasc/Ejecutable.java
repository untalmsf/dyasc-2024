package ar.edu.untref.dyasc;

import java.util.List;

public class Ejecutable {
    public static void main(String[] args) {
        try {
            Parametros parametros = Parametros.procesarArgumentos(args);
            List<Integer> serieFibonacci = Fibonacci.generar(parametros.getN());
            String resultado = Menu.modoDeOperacion(serieFibonacci, parametros.getModo());

            if (parametros.getNombreArchivo() != null) {
                Menu.escribirArchivo(parametros.getNombreArchivo(), resultado);
                System.out.println("fibo<" + parametros.getN() + "> guardado en " + parametros.getNombreArchivo());
            } else {
                Menu.imprimirFibonacci(resultado, parametros.getOrientacion(), parametros.getDireccion());
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
