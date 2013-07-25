
public class Product2Factory implements ProductFactory {
	public Product makeProduct() {
		return new ConcreteProduct2();
	}
}
