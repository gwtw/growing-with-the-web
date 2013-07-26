public class LazyLoadingSingleton
{
    private static LazyLoadingSingleton _instance;

    private LazyLoadingSingleton() { }

    public static LazyLoadingSingleton Instance
    {
        get
        {
            if (_instance == null)
                _instance = new LazyLoadingSingleton();

            return _instance;
        }
    }
}