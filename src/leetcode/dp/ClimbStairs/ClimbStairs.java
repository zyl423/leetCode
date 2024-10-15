package leetcode.dp.ClimbStairs;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * ��¥��
 *
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 *
 * ʾ�� 1��
 * ���룺n = 2
 * �����2
 * ���ͣ������ַ�����������¥����
 * 1. 1 �� + 1 ��
 * 2. 2 ��
 *
 * ʾ�� 2��
 * ���룺n = 3
 * �����3
 * ���ͣ������ַ�����������¥����
 * 1. 1 �� + 1 �� + 1 ��
 * 2. 1 �� + 2 ��
 * 3. 2 �� + 1 ��
 *
 * ��ʾ��1 <= n <= 45
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