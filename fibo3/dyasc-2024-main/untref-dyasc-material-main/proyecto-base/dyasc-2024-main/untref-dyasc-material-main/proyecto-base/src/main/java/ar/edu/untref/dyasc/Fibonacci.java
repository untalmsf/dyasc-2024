package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static List<Integer> generar(int n) {
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
}