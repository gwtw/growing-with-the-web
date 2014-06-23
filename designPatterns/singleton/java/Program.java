package designPatterns.singleton.java;

import designPatterns.singleton.java.*;

public class Program {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        LazyLoadingSingleton lazyLoadingSingleton = LazyLoadingSingleton.getInstance();
    }
}
