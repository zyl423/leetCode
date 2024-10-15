package leetcode.dp.JewelleryValue;

/**
 * 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 思路，遇到障碍物，值为0
 */
class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] r = new int[m+1][n+1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 遇到障碍物，值为0
                if (obstacleGrid[i][j] == 1) {
                    r[i][j] = 0;
                } else if ((i == m-1) && (j == n-1)) {
                    r[i][j] = 1;
                } else {
                    r[i][j] = r[i+1][j] + r[i][j+1];
                }  
            }
        }
        return r[0][0];
    }
}