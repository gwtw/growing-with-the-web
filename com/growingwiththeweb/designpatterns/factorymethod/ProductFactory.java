package com.growingwiththeweb.designpatterns.factorymethod;

public interface ProductFactory<T extends Product> {
    Product makeProduct();
}
