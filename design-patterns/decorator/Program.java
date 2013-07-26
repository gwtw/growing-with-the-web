public class Program {
	public static void main(String[] args) {
		ComponentInterface component = new ConcreteComponent();
        component.operation();
        
        // Decorate the component using ConcreteDecoratorA
        ComponentInterface decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();
        
        // Decorate the component using ConcreteDecoratorB
        ComponentInterface decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operation();
	}
}
