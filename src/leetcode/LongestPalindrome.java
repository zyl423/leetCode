package leetcode;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s){
        if (s == null || s.length() < 1) {
            return "";
        }
        int length = s.length();
        String maxStr = "";
        //从中间开始找
        int starIndex;
        starIndex = length/2;
        if(length % 2 == 0){
            starIndex--;
        }
        for (int i = 0; i <= starIndex; i++) {
            String palindrome = getPalindrome(s, starIndex - i);
            if(palindrome.length() > maxStr.length()){
                maxStr = palindrome;
            }
            if(i > 0){
                String palindrome2 = getPalindrome(s, starIndex + i);
                if(palindrome2.length() > maxStr.length()){
                    maxStr = palindrome2;
                }
            }
        }
        return maxStr;
    }

    private String getPalindrome(String str, int index){
        String str1 = leftEqualsRight(str, index);
        String str2 = indexEqualsRight(str, index);
        return str1.length() > str2.length() ? str1 : str2;
    }

    //左边和右边相等
    private String leftEqualsRight(String str, int index){
        int iMove = 1;
        int length = str.length();
        while(index >= iMove && (index + iMove) < length
                && str.charAt(index-iMove) == str.charAt(index + iMove)){
            iMove++;
        }
        return str.substring(index - iMove + 1, index + iMove);
    }

    //当前和右边相等
    private String indexEqualsRight(String str, int index){
        int iLeft = index;
        int iRight = index + 1;
        int length = str.length();
        while(iLeft >= 0 && iRight < length && str.charAt(iLeft) == str.charAt(iRight)){
            iRight++;
            iLeft--;
        }
        return str.substring(iLeft + 1, iRight);
    }

/*    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }*/

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String longestPalindromeStr = "";
        //System.out.println(getPalindrome(longestPalindromeStr, 4));
        //System.out.println(longestPalindromeStr.length());
        System.out.println(l.longestPalindrome(longestPalindromeStr));
        //System.out.println(l.indexEqualsRight(longestPalindromeStr, 0));
    }
}
