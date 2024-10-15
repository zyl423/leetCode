package leetcode.dp.JewelleryValue;

import java.util.List;

/**
 * 三角形最小路径和
 * https://leetcode.cn/problems/triangle/description/
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */

/**
 * 思路：三角形可以转换成 (n+1)*(n+1)的矩阵
 * 每个数比较下边和右下的值的大小，取小的值加上自身，公式：Math.min(r[i+1][j], r[i+1][j+1]) + value;
 *    2                20000              11,  0, 0, 0, 0
 *   3 4        -->    34000     -->      9, 10,  0, 0, 0
 *  6 5 7              65700              7,  6, 10, 0, 0
 * 4 1 8 3             41830              4,  1,  8, 3, 0
 *                     00000              0,  0,  0, 0, 0
 */
class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] r = new int[n+1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                r[i][j] = Math.min(r[i+1][j], r[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return r[0][0];
    }

    // 空间优化，由于矩阵r在实际运行时只用到了一行，可以将矩阵优化成数组
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] r = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                r[j] = Math.min(r[j], r[j+1]) + triangle.get(i).get(j);
            }
        }
        return r[0];
    }*/
}