package leetcode.dp.Rob;

import java.util.Arrays;

/**
 * ��ҽ��� II
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ���
 * ���ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�
 * ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
 */
class Rob2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                help(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                help(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int help(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        return dp[n];
    }
}