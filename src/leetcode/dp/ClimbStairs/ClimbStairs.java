package leetcode.dp.ClimbStairs;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：1 <= n <= 45
 */
class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] r = new int[n];
        r[0] = 1;
        r[1] = 2;
        for (int i = 2; i < n; i++) {
            r[i] = r[i-2] + r[i-1];
        }
        return r[n - 1];
    }

}