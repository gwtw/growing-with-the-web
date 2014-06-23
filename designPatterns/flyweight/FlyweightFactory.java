import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<Integer, Flyweight> flyweights = new HashMap<Integer, Flyweight>();

    public Flyweight get(Integer key) {
        Flyweight flyweight = flyweights.get(key);
        
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        
        return flyweight;
    }
}
