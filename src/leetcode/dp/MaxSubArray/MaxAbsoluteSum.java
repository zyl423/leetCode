package leetcode.dp.MaxSubArray;

/**
 * 任意子数组和的绝对值的最大值
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 *
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 *
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 */
class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int f = nums[0];
        int h = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            max = Math.max(f, max);
            h = Math.min(h, 0) + nums[i];
            min = Math.min(h, min);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}