package day5;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] helper = new int[128];
        for (char c : s1.toCharArray()) {
            helper[c]++;
        }
        int left = 0,right = 0,count = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            if(helper[c] >0){
                count++;
            }
            right++;
            helper[c]--;
            // 满足count == s1.length条件时，说明[left,right]已经包含s1全部字母
            while (count == s1.length()){
                // 当right-left 为 s1长度时，说明其中只存在s1的字母
                if(right-left==s1.length()){
                    return true;
                }
                char lc = s2.charAt(left);
                if(helper[lc]>=0){
                    count--;
                }
                left++;
                helper[lc]++;
            }
        }
        return false;
    }
}
