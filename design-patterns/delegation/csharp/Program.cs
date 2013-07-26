class Program
{
    static void Main(string[] args)
    {
        var delegator = new Delegator();
        
        delegator.ToA();
        delegator.F();
        
        delegator.ToB();
        delegator.F();
    }
}