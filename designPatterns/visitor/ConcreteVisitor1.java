public class ConcreteVisitor1 implements VisitorInterface {
    public void visit(ConcreteElementA element) {
        System.out.print("1 visits A");
    }

    public void visit(ConcreteElementB element) {
        System.out.print("1 visits B");
    }
}
