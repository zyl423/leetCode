package leetcode.dp.Rob;

import java.util.Arrays;

/**
 * 打家劫舍 II
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这
 * 个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                help(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                help(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int help(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        return dp[n];
    }
}