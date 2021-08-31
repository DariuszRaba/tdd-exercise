package com.tddexercise;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private int addingCounter;

    public int add(String numbers) throws Exception {
        addingCounter++;
        if (numbers.startsWith("//")) {
            return sumNumbersWithCustomDelimiter(numbers);
        }
        if (numbers.length() < 1) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else if (containNegativeNumber(numbers)) {
            throw new Exception(String.format("negatives not allowed [%s]", getNegativesFromInput(numbers.split("[,\n]"))));
        } else {
            return Arrays.stream(numbers.split("[,\n]")).mapToInt(Integer::parseInt).sum();
        }
    }

    private int sumNumbersWithCustomDelimiter(String numbers) throws Exception {
        final int endOfDelimiter = numbers.indexOf("\n");
        String delimiter = numbers.substring(2, endOfDelimiter);
        final String[] numbersArr = numbers.substring(endOfDelimiter + 1).split(delimiter);
        if (containNegativeNumber(numbers)) {
            throw new Exception(String.format("negatives not allowed [%s]", getNegativesFromInput(numbersArr)));
        }
        return Arrays.stream(numbersArr).mapToInt(Integer::parseInt).sum();
    }

    private boolean containNegativeNumber(String numbers) {
        return Pattern.compile("-[1-9]").matcher(numbers).find();
    }

    private String getNegativesFromInput(String[] numbers) {
        final StringBuilder sb = new StringBuilder("");
        for (String number : numbers
        ) {
            if (Integer.parseInt(number) < 0) sb.append(number).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public int getCalledCount() {
        return this.addingCounter;
    }
}
