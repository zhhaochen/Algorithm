package Top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2020.11.11
 * 实现一个LRU
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map = null;
    private List<Integer> list = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.isEmpty() && map.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        // 可能存在的情况
        if (map.containsKey(key)){
            list.remove(Integer.valueOf(key));
            list.add(key);
            map.put(key, value);
        }else {
            if (map.size() < capacity ){
                map.put(key, value);
                list.add(key);
            }else {
                int del = list.remove(0);
                map.remove(del);
                map.put(key, value);
                list.add(key);
            }
        }
    }
}
