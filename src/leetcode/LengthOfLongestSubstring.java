package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
/*        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;*/
/*        Map<Character, Integer> strMap = new HashMap<>();
        int starPlace = 0, maxLength = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if(strMap.containsKey(c)){
                starPlace = Math.max(strMap.get(c), starPlace);
            }
            strMap.put(c, i + 1);
            maxLength = Math.max(i - starPlace + 1, maxLength);
        }
        return maxLength;*/
        Map<Character, Integer> strMap = new HashMap<>();
        int starPlace = 0, maxLength = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            Integer charPlace = strMap.get(c);
            if(null != charPlace){
                for (int j = starPlace; j <= charPlace; j++) {
                    strMap.remove(s.charAt(j));
                }
                starPlace = charPlace + 1;
            }
            strMap.put(c, i);
            int length = i - starPlace + 1;
            if(length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String lengthOfLongestSubstring = "dvdf";
        System.out.println(lengthOfLongestSubstring.length());
        System.out.println(lengthOfLongestSubstring(lengthOfLongestSubstring));
    }
}
