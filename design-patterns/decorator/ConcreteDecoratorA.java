public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(ComponentInterface component) {
        super(component);
    }
 
    public void operation() {
        System.out.println("ConcreteDecoratorA called");
    }
}