using System;

delegate void DelegateFunction();

class Delegator
{
    private DelegateFunction _function;

    public void F() { _function(); }

    public void ToA() { _function = A; }
    public void ToB() { _function = B; }

    private void A() 
    { 
        Console.WriteLine("Delegate A called");
    }
    
    private void B() 
    { 
        Console.WriteLine("Delegate B called");
    }
}