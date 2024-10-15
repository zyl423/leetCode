package leetcode.dp.ClimbStairs;

/**
 * ����ܺ� ��
 * https://leetcode.cn/problems/combination-sum-iv/description/
 * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ������� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
 * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3], target = 4
 * �����7
 * ���ͣ�
 * ���п��ܵ����Ϊ��
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * ��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
 * ʾ�� 2��
 *
 * ���룺nums = [9], target = 3
 * �����0
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums �е�����Ԫ�� ������ͬ
 * 1 <= target <= 1000
 */
class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    f[i] += f[i - num];
                }
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3}, 32));
    }
}