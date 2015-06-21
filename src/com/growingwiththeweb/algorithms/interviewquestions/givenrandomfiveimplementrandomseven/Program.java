package com.growingwiththeweb.algorithms.interviewquestions.givenrandomfiveimplementrandomseven;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
    }

    public static int random5() {
        return new Random().nextInt(5) + 1;
    }

    public static int random7() {
        // Get 0, 5, 10, 15 or 20 then add 0-4 (4% chance for 0-24)
        int val = (random5() - 1) * 5 + (random5() - 1);
        // If 0-20, return the result modulo 7 + 1 (12% chance for 1-7), otherwise
        // call recursively (16% chance)
        return val >= 21 ? random7() : val % 7 + 1;
    }
}
