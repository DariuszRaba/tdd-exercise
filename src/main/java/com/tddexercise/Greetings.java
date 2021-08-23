package com.tddexercise;

public class Greetings {

    public String greet(String name) {
        return name == null ? "Hello, my friend." :
                name.toUpperCase().equals(name) ?
                        String.format("HELLO, %s!", name) :
                        String.format("Hello, %s.", name);
    }

    public String greet(String[] names) {
        if (names == null) return "Hello, my friend.";
        final StringBuilder sb = new StringBuilder("Hello,");
        for (int i = 0; i < names.length - 1; i++) {
            sb.append(" ").append(names[i]).append(",");
        }
        return sb.substring(0, sb.length() - 1) + " and " + names[names.length - 1] + ".";
    }
}
