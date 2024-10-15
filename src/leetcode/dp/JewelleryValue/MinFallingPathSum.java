package leetcode.dp.JewelleryValue;

import java.io.InputStreamReader;

/**
 * �½�·����С��
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/
 * ����һ�� n x n �� ���� �������� matrix �������ҳ�������ͨ�� matrix ���½�·�� �� ��С�� ��
 * �½�·�� ���Դӵ�һ���е��κ�Ԫ�ؿ�ʼ������ÿһ����ѡ��һ��Ԫ�ء�����һ��ѡ���Ԫ�غ͵�ǰ����ѡԪ��������һ�У���λ�����·������ضԽ�������������ҵĵ�һ��Ԫ�أ���������˵��λ�� (row, col) ����һ��Ԫ��Ӧ���� (row + 1, col - 1)��(row + 1, col) ���� (row + 1, col + 1) ��
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