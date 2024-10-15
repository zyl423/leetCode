package leetcode.dp.MaxSubArray;

/**
 * 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 */
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int f = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            result = Math.max(f, result);
        }
        return result;
    }
}