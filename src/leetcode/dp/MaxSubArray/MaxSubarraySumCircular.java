package leetcode.dp.MaxSubArray;

/**
 * 环形子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 *
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */

/**
 * 思路：
 * 两种情况，1. 子数组不越界  2. 子数组越界
 * 对于情况1，参考 MaxSubArray （最大子数组和）
 * 对于情况2，由于 “子数组的最大和 + 其余元素和 = 总元素和”，所以 “子数组的最大和 = 全部元素和 - 最小子数组和”
 * 结合以上两种情况可以得出结果公式 Math.max(max, (sum - min))
 *
 * 注意还有一种特殊情况，全部为负数时，最小子数组和 = 全部元素和。
 * 由于答案必须是非空数组，故结果公式修改为 sum == min ? max : Math.max(max, (sum - min))
 */
class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        int f = nums[0];
        int h = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            max = Math.max(f, max);
            h = Math.min(h, 0) + nums[i];
            min = Math.min(h, min);
            sum += nums[i];
        }
        return sum == min ? max : Math.max(max, (sum - min));
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
}