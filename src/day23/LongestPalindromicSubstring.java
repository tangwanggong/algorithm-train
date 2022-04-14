package day23;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @date 2022/4/14
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String p1 = palindrome(s,i,i);
            String p2 = palindrome(s,i,i+1);
            res = res.length() > p1.length()?res:p1;
            res = res.length() > p2.length()?res:p2;
        }
        return res;
    }

    public String palindrome(String s, int l ,int r){
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}
