public class Program {
    public static void main(String[] args) {
        ProductFactory factory1 = new Product1Factory();
        ProductFactory factory2 = new Product1Factory();

        Product product1 = factory1.makeProduct();
        Product product2 = factory2.makeProduct();
    }
}
