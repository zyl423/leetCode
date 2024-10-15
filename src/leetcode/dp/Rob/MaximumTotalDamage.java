package leetcode.dp.Rob;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * 施咒的最大总伤害
 * https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
class MaximumTotalDamage {
    public static long maximumTotalDamage (int[] nums) {
        /**
         * TreeMap 方便 key 从小到大排序
         */
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, (long) num, (a, b) -> a + b);
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        int size = map.keySet().size();
        long[] r = new long[size + 1];
        for (int i = 1; i < size + 1; i++) {
            Integer key = iterator.next();
            if (map.containsKey(key-1) && map.containsKey(key-2)) {
                r[i] = Math.max(r[i-1], r[i-3] + map.get(key));
            } else if (map.containsKey(key-1) || map.containsKey(key-2)) {
                r[i] = Math.max(r[i-1], r[i-2] + map.get(key));
            } else {
                r[i] = r[i-1] + map.get(key);
            }
        }
        return r[size];
    }

    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[]{7,1,6,6}));
    }
}