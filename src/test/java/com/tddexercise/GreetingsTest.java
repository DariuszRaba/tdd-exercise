package com.tddexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreetingsTest {

    private Greetings greetings;
    @BeforeEach
    public void beforeEachTestMethod(){
        this.greetings = new Greetings();
    }
    @Test
    public void checkInterpolation() {
        //given
        String name = "Bob";
        String shouldReturn = "Hello, Bob.";
        //when
        String greetings = greetings.greet(name);
        //then
        assertEquals(shouldReturn, greetings);
    }

}
