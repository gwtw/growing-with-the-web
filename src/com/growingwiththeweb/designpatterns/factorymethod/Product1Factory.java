package com.growingwiththeweb.designpatterns.factorymethod;

public class Product1Factory implements ProductFactory<ConcreteProduct1> {
    public Product makeProduct() {
        return new ConcreteProduct1();
    }
}
