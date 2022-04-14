package day23;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @date 2022/4/14
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0 ,r= numbers.length-1;
        while (l<r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                return new int[]{l+1,r+1};
            }else if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }
        }
        return new int[]{l+1,r+1};
    }
}
