package leetcode.dp.MaxSubArray;

/**
 * ����������͵ľ���ֵ�����ֵ
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 *
 * ����һ���������� nums ��һ�������� [numsl, numsl+1, ..., numsr-1, numsr] �� �͵ľ���ֵ Ϊ abs(numsl + numsl+1 + ... + numsr-1 + numsr) ��
 *
 * �����ҳ� nums �� �͵ľ���ֵ �������������飨����Ϊ�գ��������ظ� ���ֵ ��
 */
class MaxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int f = nums[0];
        int h = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            max = Math.max(f, max);
            h = Math.min(h, 0) + nums[i];
            min = Math.min(h, min);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}