package leetcode.dp.ClimbStairs;

/**
 * 使用最小花费爬楼梯
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = second;
            second = Math.min(first, second) + cost[i];
            first = temp;
        }
        return Math.min(first, second);
    }
}