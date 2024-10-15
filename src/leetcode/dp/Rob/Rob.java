package leetcode.dp.Rob;

/**
 * ��ҽ���
 * https://leetcode.cn/problems/house-robber/
 *
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ��
 * ����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 *
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 */
class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] r = new int[nums.length];
        r[0] = nums[0];
        r[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            r[i] = Math.max(r[i-1], r[i-2] + nums[i]);
        }
        return r[nums.length - 1];
    }
}