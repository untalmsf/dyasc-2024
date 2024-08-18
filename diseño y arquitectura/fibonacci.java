import java.util.ArrayList;
import java.util.List;

public class FibonacciApp {

    public static List<Integer> generateFibonacci(int n) {
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

    public static void main(String[] args) {
        int n = 10; // Cambia este valor para probar diferentes números

        try {
            // Generar y mostrar la serie de Fibonacci
            List<Integer> serieFibonacci = generateFibonacci(n);
            System.out.println("Los primeros " + n + " números de la serie de Fibonacci son:");
            System.out.println(serieFibonacci);
        } catch (Exception e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
}
