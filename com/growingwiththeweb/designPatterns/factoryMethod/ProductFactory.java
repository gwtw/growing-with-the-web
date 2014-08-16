package com.growingwiththeweb.designPatterns.factoryMethod;

public interface ProductFactory<T extends Product> {
    Product makeProduct();
}
