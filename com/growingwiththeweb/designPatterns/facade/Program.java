package com.growingwiththeweb.designPatterns.facade;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Program {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        ByteArrayOutputStream testOut = useTestStream();

        Facade facade = new Facade();
        facade.doSomething();

        assert testOut.toString().equals("Class1 calledClass2 called");

        System.setOut(out);
        System.out.println("Tests passed");
    }

    private static ByteArrayOutputStream useTestStream() {
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        return testOut;
    }
}
