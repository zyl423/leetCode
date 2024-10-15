package leetcode.dp.MaxSubArray;

/**
 * �˻����������
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 *
 * ����һ���������� nums �������ҳ������г˻����ķǿ�����
 * ������
 * ���������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
 */

/**
 * ˼·�� �����ֵ�����Կ�����0��ֵĸ�������������ֵ��
 *
 * ��һ��������û��0���ڣ����Ϊ���������
 *
 * 1.����Ϊż����������������ĸ���ֵ���Ϊ���ֵ��
 *
 * 2.����Ϊ�������������߿�ʼ���˵����һ������ֹͣ��һ�������ֵ�������ұ�Ҳ��һ�������ֵ�����Ƚϣ��ó����ֵ��
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