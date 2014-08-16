package com.growingwiththeweb.designPatterns.visitor.workingExample;

class Car {
    public void paint(Paint paint) {
        paint.paint(this);
    }
}
