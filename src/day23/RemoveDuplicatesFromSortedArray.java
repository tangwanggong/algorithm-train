package day23;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @date 2022/4/14
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if(nums[r] != nums[r-1]){
                l++;
                nums[l] = nums[r];
            }
        }
        return l+1;
    }
}
