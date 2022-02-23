package day14;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 * @date 2022/2/23
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        // 黑名单
        Set<String> deadendsSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendsSet.add(deadend);
        }
        // 已经使用过的数字
        Set<String> visited = new HashSet<>();
        // 初始化添加0000
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                // 如果在黑名单里,就跳过
                if(deadendsSet.contains(poll)){
                    continue;
                }
                // 匹配上的话就返回步数
                if(poll.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    // 每位加1，添加到遍历的queue中
                    String plusOne = plusOne(poll, j);
                    // 排除掉黑名单和已经遍历过的
                    if(!deadendsSet.contains(plusOne) && !visited.contains(plusOne)){
                        queue.add(plusOne);
                        visited.add(plusOne);
                    }
                    // 同上
                    String minusOne = minusOne(poll, j);
                    if(!deadendsSet.contains(minusOne) && !visited.contains(minusOne)){
                        queue.add(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            // 步数+1
            step++;
        }
        return -1;
    }

    // i位数字+1
    public String plusOne(String s,int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '9'){
            chars[i] = '0';
        }else {
            chars[i] += 1;
        }
        return new String(chars);
    }
    // i位数字-1
    public String minusOne(String s ,int i){
        char[] chars = s.toCharArray();
        if(chars[i] == '0'){
            chars[i] = '9';
        }else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
