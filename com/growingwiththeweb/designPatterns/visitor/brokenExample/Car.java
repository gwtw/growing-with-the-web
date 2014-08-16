package com.growingwiththeweb.designPatterns.visitor.brokenExample;

class Car {
	public void paint(Paint paint) {
        System.out.println("Car painted");
    }

    public void paint(RedPaint paint) {
        System.out.println("Car painted red");
    }
}
