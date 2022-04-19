package day24;

import java.util.Random;

/**
 * @date 2022/4/19
 */
public class Solution {
    private int[] pre;
    private Random random = new Random();
    public Solution(int[] w) {
        pre = new int[w.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i-1] + w[i-1];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(pre[pre.length - 1]) +1;
        return left_bound(pre,target) - 1;
    }

    private int left_bound(int[] nums,int target){
        int left = 0 ,right = nums.length-1;
        while (left<= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
