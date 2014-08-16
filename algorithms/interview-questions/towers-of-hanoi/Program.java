public class Program {
    public static void main(String[] args) {
        TowersOfHanoi towers = new TowersOfHanoi(5);

        System.out.println("Initial");
        towers.print();

        towers.moveTower(5, 0, 2, 1);
        
        System.out.println("Solved");
        towers.print();
    }
}
