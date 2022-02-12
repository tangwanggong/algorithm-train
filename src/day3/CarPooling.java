package day3;

/**
 * https://leetcode-cn.com/problems/car-pooling/
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] helper = new int[1001];
        // 差分数组: helper[i] 代表第i个元素-前i-1个元素的和
        for (int i = 0; i < trips.length; i++) {
            int c = trips[i][0],l = trips[i][1],r = trips[i][2];
            // 从l到后面的数量都加c
            helper[l] += c;
            // 为了消除上面对后面所有元素的影响,从第r个元素开始减去c
            if(r < helper.length){
                helper[r] -= c;
            }
        }
        // 代表当前车上的人
        int[] result = new int[helper.length];
        result[0] = helper[0];
        if(result[0] > capacity){
            return false;
        }
        for (int i = 1; i < helper.length; i++) {
            // 返回结果
            result[i] = result[i-1] + helper[i];
            // 如果
            if(result[i] > capacity){
                return false;
            }
        }
        return true;
    }

}
