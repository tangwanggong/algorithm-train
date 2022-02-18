package day9;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date 2022/2/18
 */
public class LRUCache2 {

    private LinkedHashMap<Integer,Integer> cache;
    private int capacity;

    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
       if(cache.containsKey(key)){
           Integer val = cache.get(key);
           cache.remove(key);
           cache.put(key,val);
           return val;
       }else {
           return -1;
       }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
        }else {
            if(cache.size() == capacity){
                Integer next = cache.keySet().iterator().next();
                cache.remove(next);
            }
            cache.put(key,value);
        }
    }
}
