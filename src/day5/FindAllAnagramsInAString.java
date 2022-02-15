package day5;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] helper = new int[128];
        for (char c : p.toCharArray()) {
            helper[c]++;
        }
        int left = 0,right = 0,count = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if(helper[c] >0){
                count++;
            }
            right++;
            helper[c]--;
            // 满足count == p.length条件时，说明[left,right]已经包含p全部字母
            while (count == p.length()){
                // 当right-left 为 p长度时，说明其中只存在p的字母
                if(right-left==p.length()){
                    result.add(left);
                }
                char lc = s.charAt(left);
                if(helper[lc]>=0){
                    count--;
                }
                left++;
                helper[lc]++;
            }
        }
        return result;
    }
}
