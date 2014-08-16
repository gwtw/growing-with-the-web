package com.growingwiththeweb.designPatterns.visitor.workingExample;

class RedPaint extends Paint {
	@Override
    public void paint(Car car) {
        System.out.println("Car painted red");
    }
}
