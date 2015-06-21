package com.growingwiththeweb.algorithms.interviewquestions.givenrandomfiveimplementrandomseven;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
    }

    public static int random5() {
        return new Random().nextInt(5) + 1;
    }

    public static int random7() {
        // If 1-21, return the result modulo 7 (12% chance for 1-7), otherwise call
        // recursively (16% chance)
        int val = (random5() - 1) * 5 + random5();
        // If 1-21, return the result modulo 7 (12% chance for 1-7), otherwise call
        // recursively (16% chance)
        return val > 21 ? random7() : val % 7 + 1;
    }
}
