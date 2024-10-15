package leetcode.dp.JewelleryValue;

/**
 * ��С·����
 * https://leetcode.cn/problems/minimum-path-sum/description/
 *
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 *
 * ʾ�� 1��
 *
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 *
 *
 * ʾ�� 2��
 *
 * ���룺grid = [[1,2,3],[4,5,6]]
 * �����12
 *
 *
 * ��ʾ��
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