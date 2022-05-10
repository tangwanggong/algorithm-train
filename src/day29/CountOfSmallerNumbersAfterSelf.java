package day29;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * @date 2022/5/7
 */
public class CountOfSmallerNumbersAfterSelf {

    private class Pair {
        int val, id;
        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }

    private Pair[] temp;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        temp = new Pair[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i],i);
        }
        int[] count = new int[nums.length];

        sort(pairs,0,nums.length-1,count);
        for (int i : count) {
            result.add(i);
        }
        return result;
    }

    private void sort(Pair[] pairs,int low,int high,int[] count){
        if(low >= high){
            return;
        }
        int mid = low + (high - low) / 2;
        sort(pairs,low,mid,count);
        sort(pairs,mid+1,high,count);

        merge(pairs,low,mid,high,count);
    }

    private void merge(Pair[] nums, int low, int mid, int high,int[] count) {
        for (int k = low; k <= high ; k++) {
            temp[k] = nums[k];
        }
        int i = low , j = mid + 1;
        for (int k = low; k <= high ; k++) {
            if(i == mid + 1){
                nums[k] = temp[j++];
            }else if (j == high + 1){
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid -1;
            }else if(temp[i].val > temp[j].val){
                nums[k] = temp[j++];
            }else {
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid -1;
            }
        }
    }

}
