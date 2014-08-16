package com.growingwiththeweb.designPatterns.visitor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Program {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        ByteArrayOutputStream testOut = useTestStream();

        VisitorInterface visitor1 = new ConcreteVisitor1();
        VisitorInterface visitor2 = new ConcreteVisitor2();
        ElementInterface elementA = new ConcreteElementA();
        ElementInterface elementB = new ConcreteElementB();

        elementA.accept(visitor1);

        assert testOut.toString().equals("1 visits A");
        testOut = useTestStream();

        elementA.accept(visitor2);

        assert testOut.toString().equals("2 visits A");
        testOut = useTestStream();

        elementB.accept(visitor1);

        assert testOut.toString().equals("1 visits B");
        testOut = useTestStream();

        elementB.accept(visitor2);

        assert testOut.toString().equals("2 visits B");

        System.setOut(out);
        System.out.println("Tests passed");
    }

    private static ByteArrayOutputStream useTestStream() {
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        return testOut;
    }
}
