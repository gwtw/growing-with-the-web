package com.growingwiththeweb.designpatterns.visitor.workingexample;

class RedPaint extends Paint {
	@Override
    public void paint(Car car) {
        System.out.println("Car painted red");
    }
}
