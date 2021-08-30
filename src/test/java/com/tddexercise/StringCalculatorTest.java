package com.tddexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void beforeEachMethodTest(){
        this.stringCalculator = new StringCalculator();
    }

    @Test
    public void Sum_Arguments_Variants_Test(){
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
        assertAll(()-> assertEquals(shouldReturnForEmptyString,emptySum),
                ()-> assertEquals(shouldReturnForOneArgument, oneArgumentSum),
                ()-> assertEquals(shouldReturnForTwoArguments, twoArgumentsSum));

    }

}
