package com.growingwiththeweb.designpatterns.factorymethod;

public class Product2Factory implements ProductFactory<ConcreteProduct2> {
    public Product makeProduct() {
        return new ConcreteProduct2();
    }
}
