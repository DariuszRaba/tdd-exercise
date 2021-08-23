package com.tddexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreetingsTest {

    private Greetings greetings;

    @BeforeEach
    public void beforeEachTestMethod() {
        this.greetings = new Greetings();
    }

    @Test
    public void checkInterpolation() {
        //given
        String name = "Bob";
        String shouldReturn = "Hello, Bob.";
        //when
        String sayHello = greetings.greet(name);
        //then
        assertEquals(shouldReturn, sayHello);
    }

    @Test
    public void checkNullValue() {
        //given
        String shouldReturn = "Hello, my friend.";
        //when
        String nullValue = null;
        String sayHello = greetings.greet(nullValue);
        //then
        assertEquals(shouldReturn, sayHello);
    }

    @Test
    public void checkShoutingBack() {
        //given
        String shouldReturn = "HELLO, JERRY!";
        //when
        String shoutBack = greetings.greet("JERRY");
        //then
        assertEquals(shouldReturn, shoutBack);
    }

    @Test
    public void checkTwoNamesGreeting() {
        //given
        String[] names = {"Jill", "Jane"};
        String shouldReturn = "Hello, Jill and Jane";
        //when
        String greeting = greetings.greet(names);
        //then
        assertEquals(shouldReturn, greeting);
    }

    @Test
    public void checkMoreThenTwoNamesHandling() {
        //given
        String[] threeNames = {"Jill", "Jane", "Judy"};
        String[] fourNames = {"Jill", "Jane", "Judy", "Michael"};
        String[] fiveNames = {"Jill", "Jane", "Judy", "Michael", "Nicole"};
        String shouldReturnforThree = "Hello, Jill, Jane and Judy.";
        String shouldReturnforFour = "Hello, Jill, Jane, Judy and Michael.";
        String shouldReturnforFive = "Hello, Jill, Jane, Judy, Michale and Nicole.";
        //when
        final String threeGreet = greetings.greet(threeNames);
        final String fourGreet = greetings.greet(fourNames);
        final String fiveGreet = greetings.greet(fiveNames);
        //then
        assertAll(() -> assertEquals(shouldReturnforThree, threeGreet),
                () -> assertEquals(shouldReturnforFour, fourGreet),
                () -> assertEquals(shouldReturnforFive, fiveGreet));
    }
}
