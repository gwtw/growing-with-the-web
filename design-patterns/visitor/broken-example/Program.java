public class Program {
    public static void main(String[] args) {
        RedPaint red = new RedPaint();
        Car car = new Car();
        Car fastCar = new FastCar();

        red.paint(car);
        red.paint(fastCar);
    }
}
