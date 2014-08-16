package com.growingwiththeweb.designPatterns.factoryMethod;

public class Product1Factory implements ProductFactory<ConcreteProduct1> {
    public Product makeProduct() {
        return new ConcreteProduct1();
    }
}
