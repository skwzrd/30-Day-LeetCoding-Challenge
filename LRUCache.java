import java.util.LinkedHashMap;
import java.util.Map;

/*
Day 24
Design and implement a data structure for
Least Recently Used (LRU) cache.
It should support the following operations: get and put.
*/
class LRUCache {
    static class Solution{
        int cap = 0;
        Map<Integer, Integer> cache;
        
        public Solution(int capacity) {
            this.cache = new LinkedHashMap<>();
            this.cap = capacity;
        }
        
        public int get(int key) {
            if(cache.containsKey(key)){
                int val = cache.get(key);
                cache.remove(key);
                cache.put(key, val);
                return val;
            }
            else{
                return -1;
            }
        }
        
        public void put(int key, int value) {
            cache.remove(key);
            cache.put(key, value);
            if(cache.size() > cap){
                int remove_key = cache.keySet().iterator().next();
                cache.remove(remove_key);
            }
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution(2);
        System.out.println(s.get(2));//-1
        s.put(2,6);
        System.out.println(s.get(1));//-1
        s.put(1,5);
        s.put(1,2);
        System.out.println(s.get(1));//2
        System.out.println(s.get(2));//6
    }

}