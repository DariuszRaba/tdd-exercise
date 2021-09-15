package com.tddexercise;

import java.util.stream.IntStream;

public class FizzBuzz {
    public void printFizzBuzz(int[] numbers) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("Invalid input");
        final String digitThree = "3";
        final String digitFive = "5";
        final StringBuilder sb = new StringBuilder("");

        for (int number : numbers) {
            boolean match = false;
            final boolean includeDigitFive = includeDigit(number, digitFive);
            final boolean includeDigitThree = includeDigit(number, digitThree);

            if (number % 3 == 0 || includeDigitThree) {
                sb.append("Fizz");
                match = true;
            }
            if (number % 5 == 0 || includeDigitFive) {
                sb.append("Buzz");
                match = true;
            }
            if (!match) {
                sb.append(number);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private boolean includeDigit(int number, String digit) {
        return String.valueOf(number).contains(digit);
    }

    public void printFizzBuzz() {
        printFizzBuzz(IntStream.rangeClosed(1, 100).toArray());
    }
}
