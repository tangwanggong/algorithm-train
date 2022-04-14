package day23;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * @date 2022/4/14
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow+1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
