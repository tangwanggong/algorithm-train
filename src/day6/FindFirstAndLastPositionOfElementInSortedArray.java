package day6;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)。
        int left = 0,right = nums.length;
        // 寻找第一个位置
        // 跳出条件为left == right
        while (left < right){
            int mid = left + (right-left) /2;
            // 寻找[left,right)区间
            if(nums[mid] == target){
                // 如果寻找到right压缩空间,找到最小的
                right = mid;
            }else if(nums[mid] > target){
                // 如果大了 因为是找[left,right)区间内的,所以right = mid
                right = mid;
            }else if(nums[mid] < target){
                // 同理 如果小了 因为是找[left,right)区间内的 left = mid + 1
                left = mid + 1;
            }
        }
        int first = left;
        if(left == nums.length || nums[left] != target){
            first = -1;
        }
        // 寻找最后一个位置
        left = 0;
        right = nums.length;
        // 跳出条件为left == right
        while (left < right){
            int mid = left + (right-left) /2;
            if(nums[mid] == target){
                // 寻找最后一个,压缩左边的空间,所以最后left不是target值了,取mid = left-1
                left = mid + 1;
            }else if(nums[mid] > target){
                // 如果大了 因为是找(left,right]区间内的,所以right = mid
                right = mid;
            }else if(nums[mid] < target){
                // 同理 如果小了 因为是找[left,right)区间内的 left = mid + 1
                left = mid+1;
            }
        }
        int last = left;
        if(left-1 < 0 || nums[left-1] != target){
            last = -1;
        }
        return new int[]{first,last};
    }
    public int[] searchRange2(int[] nums, int target) {
        //我们的「搜索区间」是 [left, right) 左闭右闭，所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid-1] 或 [mid + 1, right]。
        int left = 0,right = nums.length-1;
        // 寻找第一个位置
        // 跳出条件为left == right
        while (left <= right){
            int mid = left + (right-left) /2;
            // 寻找[left,right)区间
            if(nums[mid] == target){
                // 如果寻找到right压缩空间,找到最小的
                right = mid -1;
            }else if(nums[mid] > target){
                // 如果大了 因为是找[left,right]区间内的,所以right = mid -1
                right = mid -1;
            }else if(nums[mid] < target){
                // 同理 如果小了 因为是找[left,right]区间内的 left = mid + 1
                left = mid + 1;
            }
        }
        int first = left;
        if(left >= nums.length || nums[left] != target){
            first = -1;
        }
        // 寻找最后一个位置
        left = 0;
        right = nums.length-1;
        // 跳出条件为left == right
        while (left <= right){
            int mid = left + (right-left) /2;
            if(nums[mid] == target){
                // 寻找最后一个,压缩左边的空间,所以最后left不是target值了,取mid = left-1
                left = mid + 1;
            }else if(nums[mid] > target){
                // 如果大了 因为是找[left,right]区间内的,所以right = mid -1
                right = mid -1;
            }else if(nums[mid] < target){
                // 同理 如果小了 因为是找[left,right)区间内的 left = mid + 1
                left = mid+1;
            }
        }
        int last = right;
        if(right < 0 || nums[right] != target){
            last = -1;
        }
        return new int[]{first,last};
    }
}
