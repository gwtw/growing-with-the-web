package designPatterns.factoryMethod;

public class Product2Factory implements ProductFactory<ConcreteProduct2> {
    public Product makeProduct() {
        return new ConcreteProduct2();
    }
}
