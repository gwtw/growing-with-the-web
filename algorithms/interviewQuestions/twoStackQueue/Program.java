public class Program {
	public static void main(String[] args) {
		StackQueue<Integer> queue = new StackQueue<Integer>();
		
		assert queue.pop() == null;
		queue.push(1);
		queue.push(2);
		queue.push(3);
		assert queue.pop() == 1;
		queue.push(4);
		assert queue.pop() == 2;
		assert queue.pop() == 3;
		assert queue.pop() == 4;
		
		System.out.println("Tests passed");
	}
}