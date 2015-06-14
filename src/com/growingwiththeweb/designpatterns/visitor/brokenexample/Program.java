package com.growingwiththeweb.designpatterns.visitor.brokenexample;

public class Program {
    public static void main(String[] args) {
        Car car = new Car();
        Paint paint = new Paint();
        Paint redPaint = new RedPaint();

        car.paint(paint);
        car.paint(redPaint);
    }
}
