package leetcode.dp.ClimbStairs;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计打字方案数
 * https://leetcode.cn/problems/count-number-of-texts/description/
 *
 */
class CountTexts {
    public static int countTexts(String pressedKeys) {
        if (pressedKeys.length() == 1) {
            return 1;
        }

        int sum = 1;
        List<CharCount> charCounts = new ArrayList();
        Character currentChar = null;
        int count = 0;
        int maxCount = count;
        int max7Or9Count = count;

        for (char c : pressedKeys.toCharArray()) {
            if (null == currentChar) {
                currentChar = c;
            }
            if (c == currentChar) {
                count++;
            } else {
                charCounts.add(new CharCount(currentChar, count));
                if ('7' == currentChar || '9' == currentChar) {
                    if (count > max7Or9Count) {
                        max7Or9Count = count;
                    }
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
                currentChar = c;
                count = 1;
            }
        }

        // 不要忘记检查最后一个字符组
        if (count > 0) {
            charCounts.add(new CharCount(currentChar, count));
            if ('7' == currentChar || '9' == currentChar) {
                if (count > max7Or9Count) {
                    max7Or9Count = count;
                }
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }

        int[] r = new int[maxCount + 3];
        r[0] = 1;
        r[1] = 1;
        r[2] = 2;
        if (maxCount > 2) {
            for (int i = 3; i <= maxCount; i++) {
                double v = (r[i - 3] + r[i - 2] + r[i - 1]) % (Math.pow(10, 9) + 7);
                r[i] = (int) v;
            }
        }

        int[] r7Or9 = new int[max7Or9Count + 4];
        r7Or9[0] = 1;
        r7Or9[1] = 1;
        r7Or9[2] = 2;
        r7Or9[3] = 4;
        if (max7Or9Count > 3) {
            for (int i = 4; i <= max7Or9Count; i++) {
                double v = (r7Or9[i - 4] + r7Or9[i - 3] + r7Or9[i - 2] + r7Or9[i - 1]) % (Math.pow(10, 9) + 7);
                r7Or9[i] = (int) v;
            }
        }

        for (CharCount charCount : charCounts) {
            char chars = charCount.chars;
            Integer currentCount = charCount.count;
            if ('7' == chars || '9' == chars) {
                double v = (sum * r7Or9[currentCount]) % (Math.pow(10, 9) + 7);
                sum = (int) v;
            } else {
                double v = (sum * r[currentCount]) % (Math.pow(10, 9) + 7);
                sum = (int) v;
            }
        }
        double v = sum % (Math.pow(10, 9) + 7);
        return (int) v;
    }

    static class CharCount {
        char chars;
        Integer count;

        public CharCount(char chars, Integer count) {
            this.chars = chars;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888"));
    }


       /* 我写的方法结果精度有问题，以下是网友答案
       public int countTexts(String pressedKeys) {
            //线性DP + 滚动数组优化，时间复杂度：o(n)  空间复杂度： o(1)
            int mod = (int)(1e9 + 7), arr[] = new int[4];
            arr[0] = 1;
            for(int i = 0, n = pressedKeys.length(); i < n; i++)
            {
                char c = pressedKeys.charAt(i);
                int cur = 0, size = (c == '7' || c == '9') ? 4 : 3;
                for(int j = 0; i - j >= 0 && j < size; j++)
                {
                    if(pressedKeys.charAt(i - j) == c) cur = (cur + arr[j]) % mod;
                    else break;
                }
                arr[3] = arr[2];
                arr[2] = arr[1];
                arr[1] = arr[0];
                arr[0] = cur;
            }
            return arr[0];
        }*/
}