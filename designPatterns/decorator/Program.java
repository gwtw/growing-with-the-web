import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Program {
    public static void main(String[] args) throws IOException {
        final PrintStream out = System.out;
        ByteArrayOutputStream testOut = useTestStream();

        ComponentInterface component = new ConcreteComponent();
        component.operation();

        assert testOut.toString().equals("ConcreteComponent called");
        testOut = useTestStream();

        // Decorate the component using ConcreteDecoratorA
        ComponentInterface decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();

        assert testOut.toString().equals("ConcreteDecoratorA called");
        testOut = useTestStream();

        // Decorate the component using ConcreteDecoratorB
        ComponentInterface decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operation();

        assert testOut.toString().equals("ConcreteDecoratorB called");

        System.setOut(out);
        System.out.println("Tests passed");
    }

    private static ByteArrayOutputStream useTestStream() {
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        return testOut;
    }
}
