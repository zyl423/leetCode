package leetcode.dp.JewelleryValue;

/**
 * LCR 166. 珠宝的最高价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * 现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
 *
 * 只能从架子的左上角开始拿珠宝
 * 每次可以移动到右侧或下侧的相邻位置
 * 到达珠宝架子的右下角时，停止拿取
 * 注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: frame = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最高价值的珠宝
 *
 *
 * 提示：
 *
 * 0 < frame.length <= 200
 * 0 < frame[0].length <= 200
 */

/**
 * 思路：
 * 创建一个长宽都多1的矩阵，最右边的列和最下面的行中的值均为0
 * 从最右下角开始拿右边和下面的最大值加上自身的值，公式转换：Math.max(r[i+1][j], r[i][j+1]) + value;
 * 如示例1中的矩阵, 会转换成最右：
 * 1,3,1           1,3,1,0           12,11, 3, 0
 * 1,5,1   -->     1,5,1,0    -->     9, 8, 2, 0
 * 4,2,1           4,2,1,0            7, 3, 1, 0
 *                 0,0,0,0            0, 0, 0, 0
 *
 * 返回矩阵[0][0]的值即为答案
 */
class JewelleryValue {
    public int jewelleryValue(int[][] frame) {
        int n = frame.length;
        int m = frame[0].length;
        int[][] r = new int[n+1][m+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                r[i][j] = Math.max(r[i+1][j], r[i][j+1]) + frame[i][j];
            }
        }
        return r[0][0];
    }
}