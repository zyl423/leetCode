package leetcode.dp.MaxSubArray;

/**
 * 乘积最大子数组
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */

/**
 * 思路： 求最大值，可以看成求被0拆分的各个子数组的最大值。
 *
 * 当一个数组中没有0存在，则分为两种情况：
 *
 * 1.负数为偶数个，则整个数组的各个值相乘为最大值；
 *
 * 2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
 */
class MaxProduct {
    public int maxProduct(int[] nums) {
        double a=1;  
        double max=nums[0];
        
        for(int num:nums){
            a=a*num;
            if(max<a)max=a;
            if(num==0)a=1;

        }
        a=1;
        for(int i=nums.length-1;i>=0;i--){
            a=a*nums[i];
            if(max<a)max=a;
            if(nums[i]==0)a=1;
        }  
        return (int) max;
    }
}