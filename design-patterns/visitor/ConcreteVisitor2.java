public class ConcreteVisitor2 implements VisitorInterface {
    public void visit(ConcreteElementA element) {
        System.out.print("2 visits A");
    }

    public void visit(ConcreteElementB element) {
        System.out.print("2 visits B");
    }
}
