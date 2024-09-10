package ar.edu.untref.dyasc;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ar.edu.untref.dyasc.Fibonacci;  // Importa la clase Fibonacci
import ar.edu.untref.dyasc.Menu;       // Importa la clase Menu
import ar.edu.untref.dyasc.Parametros; // Importa la clase Parametros
import ar.edu.untref.dyasc.Ejecutable; // Importa la clase Ejecutable


public class FibonacciAppTest {

    private static final String TEMP_FILE = "salida.txt";

    @Before
    public void setUp() {
        // Eliminar el archivo temporal si existe antes de cada prueba
        try {
            Files.deleteIfExists(Paths.get(TEMP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Eliminar el archivo temporal después de cada prueba
        try {
            Files.deleteIfExists(Paths.get(TEMP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateFibonacciWithZeroTerms() {
        List<Integer> resultado = Fibonacci.generar(0);
        assertThat(resultado).isEmpty();
    }

    @Test
    public void testGenerateFibonacciWithOneTerm() {
        List<Integer> resultado = Fibonacci.generar(1);
        assertThat(resultado).containsExactly(0);
    }

    @Test
    public void testGenerateFibonacciWithTwoTerms() {
        List<Integer> resultado = Fibonacci.generar(2);
        assertThat(resultado).containsExactly(0, 1);
    }

    @Test
    public void testGenerateFibonacciWithFiveTerms() {
        List<Integer> resultado = Fibonacci.generar(5);
        assertThat(resultado).containsExactly(0, 1, 1, 2, 3);
    }

    @Test
    public void testPrintFibonacciVerticalDirect() {
        List<Integer> serieFibonacci = Fibonacci.generar(5);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu.imprimirFibonacci(Menu.modoDeOperacion(serieFibonacci, "l"), "v", "d");

        String expectedOutput = "fibo<5>: \n0\n1\n1\n2\n3\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciHorizontalInverse() {
        List<Integer> serieFibonacci = Fibonacci.generar(8);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu.imprimirFibonacci(Menu.modoDeOperacion(serieFibonacci, "l"), "h", "i");

        String expectedOutput = "fibo<8>: 13 8 5 3 2 1 1 0\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciVerticalInverse() {
        List<Integer> serieFibonacci = Fibonacci.generar(8);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu.imprimirFibonacci(Menu.modoDeOperacion(serieFibonacci, "l"), "v", "i");

        String expectedOutput = "fibo<8>: \n13\n8\n5\n3\n2\n1\n1\n0\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciInvalidOptions() {
        List<Integer> serieFibonacci = Fibonacci.generar(8);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu.imprimirFibonacci(Menu.modoDeOperacion(serieFibonacci, "l"), "x", "y");

        String expectedOutput = "Orientación inválida.\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciWithoutOptions() {
        List<Integer> serieFibonacci = Fibonacci.generar(8);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Menu.imprimirFibonacci(Menu.modoDeOperacion(serieFibonacci, "l"), "h", "d");

        String expectedOutput = "fibo<8>: 0 1 1 2 3 5 8 13\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciOutputToFile() throws IOException {
        List<Integer> serieFibonacci = Fibonacci.generar(5);
        String resultado = Menu.modoDeOperacion(serieFibonacci, "l");
        Menu.escribirArchivo(TEMP_FILE, resultado);

        String contenidoArchivo = new String(Files.readAllBytes(Paths.get(TEMP_FILE)));
        String expectedOutput = "fibo<5>: 0 1 1 2 3\n";
        assertThat(contenidoArchivo).isEqualTo(expectedOutput);
    }

    @Test
    public void testPrintFibonacciOutputToFileWithSum() throws IOException {
        List<Integer> serieFibonacci = Fibonacci.generar(5);
        String resultado = Menu.modoDeOperacion(serieFibonacci, "s");
        Menu.escribirArchivo(TEMP_FILE, resultado);

        String contenidoArchivo = new String(Files.readAllBytes(Paths.get(TEMP_FILE)));
        String expectedOutput = "fibo<5s>: 7\n";
        assertThat(contenidoArchivo).isEqualTo(expectedOutput);
    }
}
