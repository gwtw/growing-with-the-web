package com.growingwiththeweb.designPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<Integer, ConcreteFlyweight> flyweights = new HashMap<Integer, ConcreteFlyweight>();

    public ConcreteFlyweight get(Integer key) {
        ConcreteFlyweight flyweight = flyweights.get(key);
        
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        
        return flyweight;
    }
}
