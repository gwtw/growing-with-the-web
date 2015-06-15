package com.growingwiththeweb.designpatterns.singleton;

public class Program {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        LazyLoadingSingleton lazyLoadingSingleton = LazyLoadingSingleton.getInstance();
    }
}
