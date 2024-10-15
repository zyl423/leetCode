package leetcode.dp.JewelleryValue;

import java.io.InputStreamReader;

/**
 * 下降路径最小和
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 */
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int min = Integer.MAX_VALUE;
        int[][] r = new int[n+1][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    r[i][j] = Math.min(r[i+1][j], r[i+1][j+1]) + matrix[i][j];
                } else if (j == n - 1) {
                    r[i][j] = Math.min(r[i+1][j], r[i+1][j-1]) + matrix[i][j];
                } else {
                    r[i][j] = Math.min(Math.min(r[i+1][j], r[i+1][j+1]), r[i+1][j-1]) + matrix[i][j];
                }

                if (i == 0) {
                    min = Math.min(min, r[i][j]);
                }
            }
        }
        return min;
    }

}