package leetcode.dp.ClimbStairs;

/**
 * ͳ�ƹ�����ַ����ķ�����
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 *
 * �������� zero ��one ��low �� high �����Ǵӿ��ַ�����ʼ����һ���ַ�����ÿһ��ִ����������е�һ�֣�
 *
 * �� '0' ���ַ���ĩβ��� zero  �Ρ�
 * �� '1' ���ַ���ĩβ��� one �Ρ�
 * ���ϲ�������ִ������Ρ�
 *
 * ���ͨ�����Ϲ��̵õ�һ�� ���� �� low �� high ֮�䣨�������±߽磩���ַ�������ô����ַ������ǳ�Ϊ �� �ַ�����
 *
 * ���㷵����������Ҫ��� ��ͬ ���ַ�����Ŀ�����ڴ𰸿��ܴܺ��뽫����� 109 + 7 ȡ�� �󷵻ء�
 */
class CountGoodStrings {
    public static int countGoodStrings(int low, int high, int zero, int one) {
        double v = Math.pow(10, 9) + 7;
        double sum = 0;
        if (zero > high && one > high) {
            return (int) sum;
        }
        
        if (high == 1) {
            if (zero == 1) {
                sum++;
            }
            if (one == 1) {
                sum++;
            }
            return (int) sum;
        }
        double[] r = new double[high + 1];
        r[zero]++;
        r[one]++;
        for (int i = 1; i <= high; i++) {
            if (i >= zero && i < one) {
                if (i % zero == 0) {
                    r[i] = 1;
                }
            } else if (i >= one && i < zero) {
                if (i % one == 0) {
                    r[i] = 1;
                }
            } else if (i >= zero && i >= one) {
                r[i] = (r[i] + r[i-zero] + r[i-one]) % v;
            }
            if (i >= low) {
                sum += r[i];
                sum = sum % v;
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(countGoodStrings(200, 200, 10, 1));
    }
}