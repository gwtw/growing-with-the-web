package com.growingwiththeweb.designpatterns.decorator;

public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(ComponentInterface component) {
        super(component);
    }

	@Override
    public void operation() {
        System.out.print("ConcreteDecoratorB called");
    }
}
