package leetcode.dp.MaxSubArray;

/**
 * K �δ��������������֮��
 * https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 *
 * ����һ���������� arr ��һ������ k ��ͨ���ظ� k �����޸����顣
 *
 * ���磬��� arr = [1, 2] �� k = 3 ����ô�޸ĺ�����齫�� [1, 2, 1, 2, 1, 2] ��
 *
 * �����޸ĺ�������е�����������֮�͡�ע�⣬�����鳤�ȿ����� 0������������������ܺ�Ҳ�� 0��
 *
 * ���� ������ܻ�ܴ���Ҫ���ص� 109 + 7 �� ģ ��
 * 
 * 
 */

/**
 * ˼·��
 * �� k = 1 ʱ����Ϊ��ǰ������������ͣ��ο���Ʊ���⣩
 *
 * �� k >= 2 ʱ����
 *
 * sum Ϊԭ����ĺͣ�
 * result1 Ϊ k = 1 ʱ�Ĵ𰸣�
 * result2 Ϊ ���ǰ׺�� + sum - ��Сǰ׺�ͣ�����ʾ��2���������
 * ע�⵽��
 *
 * �� sum >= 0���� result2 >= result1, ��˴�Ϊ result2 + (k - 2) * sum;
 * �� sum < 0�����ܱ�֤ result2 >= result1������ (k-2) * sum < 0���ʲ�����ӣ���˴�Ϊ max(result1, result2)��
 * �ʴ𰸿�ͳһΪ max(result1, result2) + max((k - 2) * sum��0)��
 */
class KConcatenationMaxSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        double f = 0;
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            f = Math.max(f, 0) + arr[i];
            result = Math.max(f, result);
        }
        
        if (k == 1) {
            return (int) (result % (Math.pow(10, 9) + 7));
        }

        double f2 = f;
        double result2 = result;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            f2 = Math.max(f2, 0) + arr[i];
            result2 = Math.max(f2, result2);
            sum += arr[i];
        }

        return (int) ((Math.max(result, result2) + Math.max((k-2) * sum, 0)) % (Math.pow(10, 9) + 7));
    }
}