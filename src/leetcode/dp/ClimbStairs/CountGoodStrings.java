package leetcode.dp.ClimbStairs;

/**
 * 统计构造好字符串的方案数
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 *
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 *
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 *
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 *
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
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