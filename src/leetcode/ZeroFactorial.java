package leetcode;

/**
 * ½×³ËºóµÄÁã
 * @Author: Zyl
 * @Date: 2020/2/3 16:59
 */
public class ZeroFactorial {
    public static int trailingZeroes(int n) {
        int sum = 0;
        while(n >= 5) {
            n = n/5;
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }
}
