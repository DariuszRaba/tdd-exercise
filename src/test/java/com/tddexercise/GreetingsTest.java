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
        String shouldReturn = "Hello, Jill and Jane.";
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
        String shouldReturnForThree = "Hello, Jill, Jane and Judy.";
        String shouldReturnForFour = "Hello, Jill, Jane, Judy and Michael.";
        String shouldReturnForFive = "Hello, Jill, Jane, Judy, Michael and Nicole.";
        //when
        final String threeGreet = greetings.greet(threeNames);
        final String fourGreet = greetings.greet(fourNames);
        final String fiveGreet = greetings.greet(fiveNames);
        //then
        assertAll(() -> assertEquals(shouldReturnForThree, threeGreet),
                () -> assertEquals(shouldReturnForFour, fourGreet),
                () -> assertEquals(shouldReturnForFive, fiveGreet));
    }

    @Test
    public void checkMixedNormalAndShoutedNames() {
        //given
        String[] mixedNames1 = {"Amy", "BRIAN", "Charlotte"};
        String[] mixedNames2 = {"AMY", "Brian", "CHARLOTTE"};
        String shouldReturned1 = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
        String shouldReturned2 = "Hello, Brian. AND HELLO AMY AND CHARLOTTE!";
        //when
        final String greet1 = greetings.greet(mixedNames1);
        final String greet2 = greetings.greet(mixedNames2);
        //then
        assertAll(() -> assertEquals(shouldReturned1, greet1),
                () -> assertEquals(shouldReturned2, greet2));
    }
}
