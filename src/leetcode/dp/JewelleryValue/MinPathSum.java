package leetcode.dp.JewelleryValue;

/**
 * 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 *
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
class MinPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] r = new int[n+1][m+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n-1) {
                    r[i][j] = r[i][j+1] + grid[i][j];
                } else if (j == m-1) {
                    r[i][j] = r[i+1][j] + grid[i][j];
                } else {
                    r[i][j] = Math.min(r[i+1][j], r[i][j+1]) + grid[i][j];
                }
            }
        }
        return r[0][0];
    }
}