package day23;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * @date 2022/4/14
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0,r=s.length-1;
        while (l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
