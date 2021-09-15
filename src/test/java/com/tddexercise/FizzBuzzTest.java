package com.tddexercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class FizzBuzzTest {

    private FizzBuzz fizzBuzz;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        this.fizzBuzz = new FizzBuzz();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void FizzBuzz_For_Provided_Arr() {
        //given
        final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15};
        String shouldReturn = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\nFizzBuzz";
        //when
        fizzBuzz.printFizzBuzz(numbers);
        //then
        assertEquals(shouldReturn, outputStreamCaptor.toString().trim());

    }

    @Test
    public void No_Input_FizzBuzz_For_100_Numbers() {
        //given
        int numberOfElements = 100;
        //when
        fizzBuzz.printFizzBuzz();
        //then
        assertEquals(numberOfElements, outputStreamCaptor.toString().split("\n").length);
    }

    @Test
    public void Fizz_for_Numbers_With_Digit_Three() {
        //given
        final int[] numbers = {1, 23, 46, 9, 11, 13, 73};
        String shouldReturn = "1\nFizz\n46\nFizz\n11\nFizz\nFizz";
        //when
        fizzBuzz.printFizzBuzz(numbers);
        //then
        assertEquals(shouldReturn, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Buzz_For_Numbers_With_Digit_Five() {
        //given
        final int[] numbers = {52, 23, 46, 9, 11, 1451, 574};
        String shouldReturn = "Buzz\nFizz\n46\nFizz\n11\nBuzz\nBuzz";
        //when
        fizzBuzz.printFizzBuzz(numbers);
        //then
        assertEquals(shouldReturn, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Should_Throw_Expected_Exception_Message() {
        //given
        String message = "Invalid input";
        int[] emptyArr = new int[]{};
        //when
        IllegalArgumentException thrownNull = assertThrows(IllegalArgumentException.class, () -> fizzBuzz.printFizzBuzz(null));
        IllegalArgumentException thrownEmptyArr = assertThrows(IllegalArgumentException.class, () -> fizzBuzz.printFizzBuzz(emptyArr));
        //then
        assertAll(() -> assertTrue(thrownNull.getMessage().contains(message)),
                () -> assertTrue(thrownEmptyArr.getMessage().contains(message)));
    }

}
