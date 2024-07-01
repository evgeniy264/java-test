package org.example;

public class Factorial {
    public static long factorial(long number) throws IllegalArgumentException {
        long result = 1;
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        } else if (number > 20) {
            throw new IllegalArgumentException("Число должно быть не больше 20");
        }
        for (long i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(factorial(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


