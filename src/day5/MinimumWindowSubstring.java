package day5;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @date 2022/2/15
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        // 记录t字符各字符出现的次数
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        // count t总长度,l 滑动窗口左边 ,r 滑动窗口右边 ,start 开始计算的长度,截取len字符长度
        int count = t.length(),l = 0,r=0,start =0,len = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        while (r < chars.length){
            char c = chars[r];
            // 如果当前t字符存在字母need[c]，且没有超过个数
            if(need[c] >0){
                count--;
            }
            // 当前字母在need[]中的个数-1,防止重复消费
            need[c]--;
            // count为0时，说明当前从l到r中存在t的组合
            while (count==0){
                // 当前l到r的距离是否大过前面的组合距离
                if(r-l+1 < len){
                    len = r-l+1;
                    start = l;
                }
                // 此时大于等于0个数，说明字母存在于t中,count加上1
                if(need[chars[l]]>=0){
                    count++;
                }
                // 不论是否存在于t ,需要还原影响
                need[chars[l]]++;
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "":s.substring(start,start+len);
    }

}
