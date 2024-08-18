
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de términos de la serie de Fibonacci: ");
        int n = scanner.nextInt(); // Leer el valor de n desde la entrada estándar

        try {
            // Generar y mostrar la serie de Fibonacci
            List<Integer> serieFibonacci = generateFibonacci(n);
            System.out.println("Los primeros " + n + " números de la serie de Fibonacci son:");
            System.out.println(serieFibonacci);
        } catch (Exception e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}