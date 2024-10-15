package leetcode.dp.ClimbStairs;

/**
 * ʹ����С������¥��
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 *
 * ����һ���������� cost ������ cost[i] �Ǵ�¥�ݵ� i ��̨����������Ҫ֧���ķ��á�һ����֧���˷��ã�����ѡ��������һ����������̨�ס�
 *
 * �����ѡ����±�Ϊ 0 ���±�Ϊ 1 ��̨�׿�ʼ��¥�ݡ�
 *
 * ������㲢���شﵽ¥�ݶ�������ͻ��ѡ�
 */
class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = second;
            second = Math.min(first, second) + cost[i];
            first = temp;
        }
        return Math.min(first, second);
    }
}