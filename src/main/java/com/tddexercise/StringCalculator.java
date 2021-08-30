package com.tddexercise;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        final int numbersLength = numbers.length();
        if(numbers.startsWith("//")){
            return sumNumbersWithCustomDelimiter(numbers);
        }
        switch (numbersLength) {
            case 0:
                return 0;
            case 1:
                return Integer.parseInt(numbers);
        }
        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }

    private int sumNumbersWithCustomDelimiter(String numbers) {
        final int endOfDelimiter = numbers.indexOf("\n");
        String delimiter = numbers.substring(2,endOfDelimiter);
        return Arrays.stream(numbers.substring(endOfDelimiter+1).split(delimiter)).mapToInt(Integer::parseInt).sum();
    }
}
