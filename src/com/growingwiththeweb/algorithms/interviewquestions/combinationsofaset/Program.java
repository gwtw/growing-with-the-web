package com.growingwiththeweb.algorithms.interviewquestions.combinationsofaset;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<String> combinations = getCombinations("abc");

        assert combinations.size() == 7;
        assert combinations.contains("a");
        assert combinations.contains("b");
        assert combinations.contains("c");
        assert combinations.contains("ab") ||
               combinations.contains("ba");
        assert combinations.contains("ac") ||
               combinations.contains("ca");
        assert combinations.contains("bc") ||
               combinations.contains("cb");
        assert combinations.contains("abc") ||
               combinations.contains("acb") ||
               combinations.contains("bac") ||
               combinations.contains("bca") ||
               combinations.contains("cab") ||
               combinations.contains("cba");

  	    System.out.println("Tests passed");
    }

    public static ArrayList<String> getCombinations(String text) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {
            // Record size as we will be adding to the list
            int resultsLength = results.size();
            for (int j = 0; j < resultsLength; j++) {
                results.add(text.charAt(i) + results.get(j));
            }
            results.add(Character.toString(text.charAt(i)));
        }
        return results;
    }
}
