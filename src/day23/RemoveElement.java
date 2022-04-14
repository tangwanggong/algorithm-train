package day23;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @date 2022/4/14
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
