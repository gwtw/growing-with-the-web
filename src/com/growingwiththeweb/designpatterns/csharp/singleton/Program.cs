class Program
{
    static void Main(string[] args)
    {
        var singleton = Singleton.Instance;

        var lazyLoadingSingleton = LazyLoadingSingleton.Instance;
    }
}
