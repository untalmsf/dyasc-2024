package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.Collections;
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

    public static void printFibonacci(List<Integer> serieFibonacci, String orientation, String direction) {
        if (direction.equals("i")) {
            Collections.reverse(serieFibonacci);
        }

        if (orientation.equals("h")) {
            System.out.print("fibo<" + serieFibonacci.size() + ">: ");
            for (int i = 0; i < serieFibonacci.size(); i++) {
                System.out.print(serieFibonacci.get(i));
                if (i < serieFibonacci.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else if (orientation.equals("v")) {
            System.out.println("fibo<" + serieFibonacci.size() + ">: ");
            for (Integer number : serieFibonacci) {
                System.out.println(number);
            }
        } else {
            System.out.println("Opciones no válidas.");
        }
    }

    public static void main(String[] args) {
        String orientation = "h";
        String direction = "d";
        int n = 0;

        if (args.length > 0) {
            if (args[0].startsWith("-o=")) {
                String option = args[0].substring(3);
                if (option.length() == 2) {
                    orientation = option.substring(0, 1);
                    direction = option.substring(1, 2);

                    if ((!orientation.equals("h") && !orientation.equals("v")) ||
                        (!direction.equals("d") && !direction.equals("i"))) {
                        System.out.println("Opciones no válidas.");
                        return;
                    }
                } else {
                    System.out.println("Opciones no válidas.");
                    return;
                }
                n = Integer.parseInt(args[1]);
            } else {
                n = Integer.parseInt(args[0]);
            }
        }

        try {
            List<Integer> serieFibonacci = generateFibonacci(n);
            printFibonacci(serieFibonacci, orientation, direction);
        } catch (Exception e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
}
