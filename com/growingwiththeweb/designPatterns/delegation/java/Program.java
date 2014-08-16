package com.growingwiththeweb.designPatterns.delegation.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.designPatterns.delegation.*;

public class Program {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        ByteArrayOutputStream testOut = useTestStream();

        Delegator delegator = new Delegator();

        delegator.toA();
        delegator.f();

        assert testOut.toString().equals("Delegate A called");
        testOut = useTestStream();

        delegator.toB();
        delegator.f();

        assert testOut.toString().equals("Delegate B called");

        System.setOut(out);
        System.out.println("Tests passed");
    }

    private static ByteArrayOutputStream useTestStream() {
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        return testOut;
    }
}
