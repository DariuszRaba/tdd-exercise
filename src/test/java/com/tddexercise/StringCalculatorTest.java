package com.tddexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void beforeEachMethodTest() {
        this.stringCalculator = new StringCalculator();
    }

    @Test
    public void Sum_Arguments_Variants_Test() {
        //given
        String emptyString = "";
        String oneArgument = "1";
        String twoArguments = "1,2";
        int shouldReturnForEmptyString = 0;
        int shouldReturnForOneArgument = 1;
        int shouldReturnForTwoArguments = 3;
        //when
        final int emptySum = stringCalculator.add(emptyString);
        final int oneArgumentSum = stringCalculator.add(oneArgument);
        final int twoArgumentsSum = stringCalculator.add(twoArguments);
        //then
        assertAll(() -> assertEquals(shouldReturnForEmptyString, emptySum),
                () -> assertEquals(shouldReturnForOneArgument, oneArgumentSum),
                () -> assertEquals(shouldReturnForTwoArguments, twoArgumentsSum));

    }

    @Test
    public void Sum_Multiple_Numbers() {
        //given
        String numbers1 = "321,4342,432,121,3";
        String numbers2 = "1,442,223,11,31,164,686,";
        String numbers3 = "0,2,23,5678,641,1601,6854";
        int shouldReturnForNumbers1 = 5_219;
        int shouldReturnForNumbers2 = 1_558;
        int shouldReturnForNumbers3 = 14_799;
        //when
        final int sumOfNumbers1 = stringCalculator.add(numbers1);
        final int sumOfNumbers2 = stringCalculator.add(numbers2);
        final int sumOfNumbers3 = stringCalculator.add(numbers3);
        //then
        assertAll(() -> assertEquals(shouldReturnForNumbers1, sumOfNumbers1),
                () -> assertEquals(shouldReturnForNumbers2, sumOfNumbers2),
                () -> assertEquals(shouldReturnForNumbers3, sumOfNumbers3));

    }

    @Test
    public void Sum_Numbers_Separated_With_New_Line() {
        //given
        String numbers1 = "1\n2,3";
        String numbers2 = "1,2\n3";
        String numbers3 = "1\n2\n3";
        int shouldReturn = 6;
        //when
        final int sumOfNumbers1 = stringCalculator.add(numbers1);
        final int sumOfNumbers2 = stringCalculator.add(numbers2);
        final int sumOfNumbers3 = stringCalculator.add(numbers3);
        //then
        assertAll(
                () -> assertEquals(shouldReturn, sumOfNumbers1),
                () -> assertEquals(shouldReturn, sumOfNumbers2),
                () -> assertEquals(shouldReturn, sumOfNumbers3));
    }

    @Test
    public void Sum_numbers_Separated_With_Different_Delimiters() {
        //given
        String numbers1 = "//;\n1;2;3";
        String numbers2 = "//&\n1&2&3";
        String numbers3 = "//@\n1@2@3";
        String numbers4 = "//plus\n1plus2plus3";
        int shouldReturn = 6;
        //when
        final int sumOfNumbers1 = stringCalculator.add(numbers1);
        final int sumOfNumbers2 = stringCalculator.add(numbers2);
        final int sumOfNumbers3 = stringCalculator.add(numbers3);
        final int sumOfNumbers4 = stringCalculator.add(numbers4);
        //then
        assertAll(
                () -> assertEquals(shouldReturn, sumOfNumbers1),
                () -> assertEquals(shouldReturn, sumOfNumbers2),
                () -> assertEquals(shouldReturn, sumOfNumbers3),
                () -> assertEquals(shouldReturn, sumOfNumbers4));
    }

}
