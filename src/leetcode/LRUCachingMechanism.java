package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU�������
 * @Author: Zyl
 * @Date: 2020/2/3 17:03
 */
public class LRUCachingMechanism {
    static class LRUCache {

        private int cap;
        /** LinkedHashMap�ĵ�����������Ϊtrueʱ��������ִ��get����ʱ����afterNodeAccess������ʹ��get��entry�ƶ�����β */
        private Map<Integer, Integer> map = new LinkedHashMap<>(10,0.75F,true);

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (map.keySet().contains(key)) {
                int value = map.get(key);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.keySet().contains(key)) {
                map.remove(key);
            } else if (map.size() == cap) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        int capacity = 5;
        LRUCache cache = new LRUCache(capacity);
        // �˴�Ϊǳ����
        Map<Integer, Integer> map = cache.map;
        int i = 0;
        while (i++ < capacity) {
            cache.put(i, i);
        }
        map.forEach((key, value) -> System.out.println(key));
        System.out.println("===============");

        // get 3 ��3��������β
        cache.get(3);
        map.forEach((key, value) -> System.out.println(key));
        System.out.println("===============");

        // get 2 ��2��������β
        cache.get(2);
        map.forEach((key, value) -> System.out.println(key));
        System.out.println("===============");

        // put i ֮��i�����β������Ԫ�ر��Ƴ�
        cache.put(i, i);
        map.forEach((key, value) -> System.out.println(key));
    }
}
