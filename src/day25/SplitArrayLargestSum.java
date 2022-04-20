package day25;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 * @date 2022/4/20
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0,sum = 0;
        for (int num : nums) {
            max = Math.max(max,num);
            sum += num;
        }
        int left = max,right = sum;
        while (left < right){
            int mid = left + (right- left)/2;
            if(helper(nums,mid) > m){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private int helper (int[] nums,int sum){
        int split = 1;
        int curSum = 0;
        for (int num : nums) {
            if(curSum + num > sum){
                split++;
                curSum = 0;
            }
            curSum += num;
        }
        return split;
    }
}
