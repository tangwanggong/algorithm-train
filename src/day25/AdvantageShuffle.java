package day25;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/advantage-shuffle/
 * @date 2022/4/20
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] sortedNums1 = nums1.clone();
        int[] sortedNums2 = nums2.clone();
        Arrays.sort(sortedNums1);
        Arrays.sort(sortedNums2);
        Deque<Integer> remaining = new LinkedList<>();
        Map<Integer,Deque<Integer>> map = new HashMap<>();
        int j = 0;
        for (int num1 : sortedNums1) {
            if(num1 > sortedNums2[j]){
                Deque<Integer> deque = map.getOrDefault(sortedNums2[j], new LinkedList<>());
                deque.addLast(num1);
                map.put(sortedNums2[j],deque);
                j++;
            }else {
                remaining.addLast(num1);
            }
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int num2 = nums2[i];
            Deque<Integer> deque = map.getOrDefault(num2, new LinkedList<>());
            if(!deque.isEmpty()){
                result[i] = deque.pop();
            }else {
                result[i] = remaining.pop();
            }
        }
        return result;
    }
}
