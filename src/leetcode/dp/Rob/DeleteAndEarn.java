package leetcode.dp.Rob;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/
 */
class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        /**
         * TreeMap 方便 key 从小到大排序
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, num, (a, b) -> a + b);
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        int first = 0, second = 0, result = 0;
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            // 如果存在相邻的元素
            if (map.containsKey(key-1)) {
                result = Math.max(second, first + map.get(key));
            } else {
                result = Math.max(first, second) + map.get(key);
            }
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}