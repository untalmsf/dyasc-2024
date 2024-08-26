package ar.edu.untref.dyasc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class FibonacciAppTest {

    @Test
    public void testGenerateFibonacciWithZeroTerms() {
        List<Integer> resultado = FibonacciApp.generateFibonacci(0);
        assertThat(resultado).isEmpty();
    }

    @Test
    public void testGenerateFibonacciWithOneTerm() {
        List<Integer> resultado = FibonacciApp.generateFibonacci(1);
        assertThat(resultado).containsExactly(0);
    }

    @Test
    public void testGenerateFibonacciWithTwoTerms() {
        List<Integer> resultado = FibonacciApp.generateFibonacci(2);
        assertThat(resultado).containsExactly(0, 1);
    }

    @Test
    public void testGenerateFibonacciWithFiveTerms() {
        List<Integer> resultado = FibonacciApp.generateFibonacci(5);
        assertThat(resultado).containsExactly(0, 1, 1, 2, 3);
    }
    @Test
    public void testPrintFibonacciVerticalDirect() {
        List<Integer> serieFibonacci = FibonacciApp.generateFibonacci(5);
        // Captura la salida del método printFibonacci
        // Este ejemplo utiliza un buffer para capturar la salida estándar
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        FibonacciApp.printFibonacci(serieFibonacci, "v", "d");

        String expectedOutput = "fibo<5>: \n0\n1\n1\n2\n3\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciHorizontalInverse() {
        List<Integer> serieFibonacci = FibonacciApp.generateFibonacci(8);
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        FibonacciApp.printFibonacci(serieFibonacci, "h", "i");

        String expectedOutput = "fibo<8>: 13 8 5 3 2 1 1 0\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciVerticalInverse() {
        List<Integer> serieFibonacci = FibonacciApp.generateFibonacci(8);
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        FibonacciApp.printFibonacci(serieFibonacci, "v", "i");

        String expectedOutput = "fibo<8>: \n13\n8\n5\n3\n2\n1\n1\n0\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciInvalidOptions() {
        List<Integer> serieFibonacci = FibonacciApp.generateFibonacci(8);
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        FibonacciApp.printFibonacci(serieFibonacci, "x", "y");

        String expectedOutput = "Opciones no válidas.\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciWithoutOptions() {
        List<Integer> serieFibonacci = FibonacciApp.generateFibonacci(8);
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        FibonacciApp.printFibonacci(serieFibonacci, "h", "d");

        String expectedOutput = "fibo<8>: 0 1 1 2 3 5 8 13\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}

