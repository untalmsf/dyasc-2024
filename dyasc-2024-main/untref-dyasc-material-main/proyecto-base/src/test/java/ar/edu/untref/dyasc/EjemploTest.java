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
}

