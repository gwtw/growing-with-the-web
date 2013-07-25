
public class Product1Factory implements ProductFactory {
	public Product makeProduct() {
		return new ConcreteProduct1();
	}
}
