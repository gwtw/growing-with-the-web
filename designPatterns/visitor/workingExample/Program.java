public class Program {
    public static void main(String[] args) {
        Car car = new Car();
        Paint paint = new Paint();
        RedPaint redpaint = new RedPaint();

        car.paint(paint);
        car.paint(redpaint);
    }
}
