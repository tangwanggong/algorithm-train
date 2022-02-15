package day5;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] helper = new int[128];
        int left = 0,right =0;
        int result = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            helper[c]++;
            right++;
            // 当不满足无重复字母的条件，就left+1，完成这个条件
            while (helper[c]>1){
                char lc = s.charAt(left);
                helper[lc]--;
                left++;
            }
            // 完成无重复字母的条件后，计算最长值
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
