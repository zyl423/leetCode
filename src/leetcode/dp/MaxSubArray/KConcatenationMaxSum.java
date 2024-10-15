package leetcode.dp.MaxSubArray;

/**
 * K 次串联后最大子数组之和
 * https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 *
 * 给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。
 *
 * 例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。
 *
 * 返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，需要返回的 109 + 7 的 模 。
 * 
 * 
 */

/**
 * 思路：
 * 当 k = 1 时，答案为当前数组的最大子序和（参考股票问题）
 *
 * 当 k >= 2 时，令
 *
 * sum 为原数组的和；
 * result1 为 k = 1 时的答案；
 * result2 为 最大前缀和 + sum - 最小前缀和（类似示例2的情况）；
 * 注意到，
 *
 * 若 sum >= 0，则 result2 >= result1, 因此答案为 result2 + (k - 2) * sum;
 * 若 sum < 0，则不能保证 result2 >= result1，但是 (k-2) * sum < 0，故不能添加，因此答案为 max(result1, result2)。
 * 故答案可统一为 max(result1, result2) + max((k - 2) * sum，0)。
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