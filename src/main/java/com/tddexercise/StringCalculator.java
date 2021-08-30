package com.tddexercise;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        final int numbersLength = numbers.length();
        switch (numbersLength) {
            case 0:
                return 0;
            case 1:
                return Integer.parseInt(numbers);
        }
        return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
    }
}
