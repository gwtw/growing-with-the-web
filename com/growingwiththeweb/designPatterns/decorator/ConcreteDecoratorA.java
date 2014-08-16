package com.growingwiththeweb.designPatterns.decorator;

public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(ComponentInterface component) {
        super(component);
    }

	@Override
    public void operation() {
        System.out.print("ConcreteDecoratorA called");
    }
}
