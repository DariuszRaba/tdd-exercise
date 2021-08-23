package com.tddexercise;

public class Greetings {

    public String greet(String name) {
        return name == null ? "Hello, my friend." :
                name.toUpperCase().equals(name) ?
                        String.format("HELLO, %s!", name) :
                        String.format("Hello, %s.", name);
    }

    public String greet(String[] names) {
        if(names==null)return "Hello, my friend.";
        return String.format("Hello, %s and %s", names[0],names[1]);
    }
}
