package day8;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/random-pick-with-blacklist/
 * @date 2022/2/17
 */
public class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    int length;
    private Random random = new Random();

    public Solution(int n, int[] blacklist) {
        for (int i : blacklist) {
            // 黑名单索引
            map.put(i,-1);
        }
        // last指向最后一位数
        int last = n - 1;
        // length永远指向应该有多少个非黑名单数字
        length = n - blacklist.length;
        for (int i : blacklist) {
            // 如果 >= length ，因为查不到，就不需要存储起来
            if(i >= length){
                continue;
            }
            // 当最后一位数也是黑名单，找前一位
            while (map.containsKey(last)){
                last--;
            }
            // 找到第一个非黑名单数字，把黑名单的索引的值写上它
            map.put(i,last);
            // last 用过，找下个
            last--;
        }
    }

    public int pick() {
        int i = random.nextInt(length);
        if(map.containsKey(i)){
            return map.get(i);
        }
        return i;
    }
}
