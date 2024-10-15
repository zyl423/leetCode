package leetcode.dp.MaxSubArray;

/**
 * ���������������
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 *
 * ����һ������Ϊ n �Ļ����������� nums ������ nums �ķǿ� ������ �������ܺ� ��
 *
 * �������� ��ζ�������ĩ�˽����뿪ͷ�����ʻ�״����ʽ�ϣ� nums[i] ����һ��Ԫ���� nums[(i + 1) % n] �� nums[i] ��ǰһ��Ԫ���� nums[(i - 1 + n) % n] ��
 *
 * ������ ���ֻ�ܰ����̶������� nums �е�ÿ��Ԫ��һ�Ρ���ʽ�ϣ����������� nums[i], nums[i + 1], ..., nums[j] �������� i <= k1, k2 <= j ���� k1 % n == k2 % n ��
 */

/**
 * ˼·��
 * ���������1. �����鲻Խ��  2. ������Խ��
 * �������1���ο� MaxSubArray �����������ͣ�
 * �������2������ ������������� + ����Ԫ�غ� = ��Ԫ�غ͡������� ������������� = ȫ��Ԫ�غ� - ��С������͡�
 * �����������������Եó������ʽ Math.max(max, (sum - min))
 *
 * ע�⻹��һ�����������ȫ��Ϊ����ʱ����С������� = ȫ��Ԫ�غ͡�
 * ���ڴ𰸱����Ƿǿ����飬�ʽ����ʽ�޸�Ϊ sum == min ? max : Math.max(max, (sum - min))
 */
class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        int f = nums[0];
        int h = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            max = Math.max(f, max);
            h = Math.min(h, 0) + nums[i];
            min = Math.min(h, min);
            sum += nums[i];
        }
        return sum == min ? max : Math.max(max, (sum - min));
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
}