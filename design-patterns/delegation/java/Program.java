public class Program {
	public static void main(String[] args) {
		Delegator delegator = new Delegator();
        
        delegator.toA();
        delegator.f();
        
        delegator.toB();
        delegator.f();
	}
}
