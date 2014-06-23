package designPatterns.factoryMethod;

public interface ProductFactory<T extends Product> {
    Product makeProduct();
}
