package com.growingwiththeweb.designpatterns.delegation;

class Delegator implements DelegationInterface {
    private DelegationInterface delegate;

    public void f() { delegate.f(); }
    public void toA() { delegate = new DelegateA(); }
    public void toB() { delegate = new DelegateB(); }
}
