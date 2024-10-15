package leetcode.dp.JewelleryValue;

import java.util.List;

/**
 * ��������С·����
 * https://leetcode.cn/problems/triangle/description/
 *
 * ����һ�������� triangle ���ҳ��Զ����µ���С·���͡�
 * ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ����ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣Ҳ����˵�������λ�ڵ�ǰ�е��±� i ����ô��һ�������ƶ�����һ�е��±� i �� i + 1 ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * �����11
 * ���ͣ��������ͼ��ʾ��
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * �Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
 *
 *
 * ʾ�� 2��
 *
 * ���룺triangle = [[-10]]
 * �����-10
 *
 *
 * ��ʾ��
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 */

/**
 * ˼·�������ο���ת���� (n+1)*(n+1)�ľ���
 * ÿ�����Ƚ��±ߺ����µ�ֵ�Ĵ�С��ȡС��ֵ����������ʽ��Math.min(r[i+1][j], r[i+1][j+1]) + value;
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

    // �ռ��Ż������ھ���r��ʵ������ʱֻ�õ���һ�У����Խ������Ż�������
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