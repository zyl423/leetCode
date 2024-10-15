package leetcode.dp.MaxSubArray;

/**
 * ����������
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * ������
 * �������е�һ���������֡�
 */
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int f = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f = Math.max(f, 0) + nums[i];
            result = Math.max(f, result);
        }
        return result;
    }
}