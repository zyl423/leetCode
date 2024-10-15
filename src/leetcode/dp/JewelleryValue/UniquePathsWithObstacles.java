package leetcode.dp.JewelleryValue;

/**
 * ��ͬ·�� II
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish������
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 *
 * ˼·�������ϰ��ֵΪ0
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
                // �����ϰ��ֵΪ0
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