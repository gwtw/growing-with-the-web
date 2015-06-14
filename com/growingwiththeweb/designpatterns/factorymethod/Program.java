package com.growingwiththeweb.designpatterns.factorymethod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
	private static Logger log = Logger.getLogger( Program.class.getName());
    public static void main(String[] args) {
        ProductFactory factory1 = new Product1Factory();
        ProductFactory factory2 = new Product1Factory();

        Product product1 = factory1.makeProduct();
		log.log(Level.INFO, "product1 is a {0}", product1.getClass().getName());
        Product product2 = factory2.makeProduct();
		log.log(Level.INFO, "product2 is a {0}", product2.getClass().getName());
     }
}
