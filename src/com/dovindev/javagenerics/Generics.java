package com.dovindev.javagenerics;

import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        String[] products = {"arroz", "frijol", "azucar", "aceite", "sal"};
        Integer[] enteros = {1,2,3,4};

        List<String> productsList = arrayToList(products);
        List<Integer> enterosList = arrayToList(enteros);

        productsList.forEach(System.out::println);

        System.out.println("el maximo es: " + max(3.45, 405.1, 12.15));
    }
    public static <T extends Number> List<T> arrayToList(T[] t){
        return Arrays.asList(t);
    }
    public static <T> List<T> arrayToList(T[] t){
        return Arrays.asList(t);
    }

    public static <T extends Comparable<T>> T max(T a, T b, T c){
        T max = a;
        if (b.compareTo(max) > 0){
            max = b;
        } if (c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
