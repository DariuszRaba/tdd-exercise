package com.tddexercise;

import java.util.*;

public class Greetings {

    public String greet(String name) {
        return name == null ? "Hello, my friend." :
                name.toUpperCase().equals(name) ?
                        String.format("HELLO, %s!", name) :
                        String.format("Hello, %s.", name);
    }

    public String greet(String[] names) {
        if (names == null) return "Hello, my friend.";
        names = checkNamesWithCommas(names).toArray(new String[0]);
        final ArrayList<String> lowerCaseNames = new ArrayList<>();
        final ArrayList<String> upperCaseNames = new ArrayList<>();
        for (String name : names) {
            if (name.equals(name.toUpperCase())) {
                upperCaseNames.add(name);
            } else {
                lowerCaseNames.add(name);
            }
        }
        return lowerCaseNames.size() == 0 ? upperCaseGreet(upperCaseNames) : upperCaseNames.size() == 0 ?
                lowerCaseGreet(lowerCaseNames) : lowerCaseGreet(lowerCaseNames) + upperCaseGreet(upperCaseNames);
    }

    private List<String> checkNamesWithCommas(String[] names) {
        final ArrayList<String> noCommasNames = new ArrayList<>();
        for (String element : names
        ) {
            for (String name : element.split(",")) {
                noCommasNames.add(name.replaceAll("\\s", ""));
            }
        }
        return noCommasNames;
    }


    private String lowerCaseGreet(List<String> names) {
        final StringBuilder sb = new StringBuilder("Hello,");
        for (int i = 0; i < names.size() - 1; i++) {
            sb.append(" ").append(names.get(i)).append(",");
        }
        if (names.size() == 1) {
            return sb.substring(0) + " " + names.get(0) + ".";
        } else {
            return sb.substring(0, sb.length() - 1) + " and " + names.get(names.size() - 1) + ".";
        }
    }

    private String upperCaseGreet(List<String> names) {
        final StringBuilder sb = new StringBuilder(" AND HELLO");
        for (int i = 0; i < names.size() - 1; i++) {
            sb.append(" ").append(names.get(i)).append(",");
        }
        if (names.size() == 1) {
            return sb.substring(0) + " " + names.get(0) + "!";
        } else {
            return sb.substring(0, sb.length() - 1) + " AND " + names.get(names.size() - 1) + "!";
        }
    }
}
