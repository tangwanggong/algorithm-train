package day2;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class NumArray {

    int[] pre;

    public NumArray(int[] nums) {
        // 构造数组
        pre = new int[nums.length+1];
        // pre[i] 代表前i个nums数组中的数加和, i=0时,设置为0,方便计算
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        // 计算时,选择right+1(也就是前i的nums加和)-left(前left个nums的值)
        return pre[right+1]-pre[left];
    }
}
