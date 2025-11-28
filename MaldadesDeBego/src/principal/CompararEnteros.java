package principal;

import java.util.*;

public class CompararEnteros {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 3);
        System.out.println("Original: " + numeros);

        Collections.sort(numeros);
        System.out.println("Ordenados: " + numeros);
    }
}