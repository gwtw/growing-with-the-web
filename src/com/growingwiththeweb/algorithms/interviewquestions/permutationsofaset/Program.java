package com.growingwiththeweb.algorithms.interviewquestions.permutationsofaset;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<String> permutations = getPermutations("abc");

        assert permutations.size() == 6;
        assert permutations.contains("abc");
        assert permutations.contains("acb");
        assert permutations.contains("bac");
        assert permutations.contains("bca");
        assert permutations.contains("cab");
        assert permutations.contains("cba");

        System.out.println("Tests passed");
    }

    public static ArrayList<String> getPermutations(String text) {
        ArrayList<String> results = new ArrayList<String>();

        // the base case
        if (text.length() == 1) {
            results.add(text);
            return results;
        }

        for (int i = 0; i < text.length(); i++) {
            char first = text.charAt(i);
            String remains = text.substring(0, i) + text.substring(i + 1);

            ArrayList<String> innerPermutations = getPermutations(remains);

            for (int j = 0; j < innerPermutations.size(); j++)
                results.add(first + innerPermutations.get(j));
        }

        return results;
    }
}
