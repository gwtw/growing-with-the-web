package com.growingwiththeweb.designPatterns.flyweight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Program {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        ByteArrayOutputStream testOut = useTestStream();

        FlyweightFactory factory = new FlyweightFactory();
        ConcreteFlyweight flyweight1 = new ConcreteFlyweight(3);
        ConcreteFlyweight flyweight2 = new ConcreteFlyweight(7);
        ConcreteFlyweight flyweight3 = new ConcreteFlyweight(2);

        flyweight1.operation(2);
        
        assert testOut.toString().equals("Intrinsic: 3, Extrinsic: 2");
        testOut = useTestStream();

        flyweight2.operation(1);
        
        assert testOut.toString().equals("Intrinsic: 7, Extrinsic: 1");
        testOut = useTestStream();

        flyweight3.operation(8);
        
        assert testOut.toString().equals("Intrinsic: 2, Extrinsic: 8");

        System.setOut(out);
        System.out.println("Tests passed");
    }

    private static ByteArrayOutputStream useTestStream() {
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        return testOut;
    }
}
