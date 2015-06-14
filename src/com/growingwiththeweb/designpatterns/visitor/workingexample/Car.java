package com.growingwiththeweb.designpatterns.visitor.workingexample;

class Car {
    public void paint(Paint paint) {
        paint.paint(this);
    }
}
