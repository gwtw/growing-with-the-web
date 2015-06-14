package com.growingwiththeweb.designpatterns.facade;

public class Facade {
    private Class1 class1;
    private Class2 class2;

    public Facade() {
        class1 = new Class1();
        class2 = new Class2();
    }

    public void doSomething() {
        class1.doSomething();
        class2.doSomething();
    }
}
