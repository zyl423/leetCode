package leetcode.dp.MaxSubArray;

/**
 * 拼接数组的最大分数
 * https://leetcode.cn/problems/maximum-score-of-spliced-array/description/
 *
 * 解题思路：https://www.bilibili.com/video/BV1pW4y1r7xs/?spm_id_from=333.788&vd_source=5b92fa9454a364b6cf5aa34e85698f4a
 * 第八分钟开始
 *
 * 假设交换的区间最左边坐标为l，最右边为r
 * 核心公式：max(a) = sum(a) + (b[l] - a[l]) + (b[l+1] - a[l+1]) + ... + (b[r] - a[r])
 * 再比较 max(a), max(b)哪个大
 */
class MaximumsSplicedArray {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1, nums2), solve(nums2, nums1));
    }

    int solve(int[] nums1, int[] nums2) {
        int s1 = 0, maxSum = 0;
        for (int i = 0, s = 0; i < nums1.length; ++i) {
            s1 += nums1[i];
            s = Math.max(s + nums2[i] - nums1[i], 0);
            maxSum = Math.max(maxSum, s);
        }
        return s1 + maxSum;
    }
}