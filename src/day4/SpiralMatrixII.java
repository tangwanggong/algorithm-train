package day4;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @date 2022/2/14
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // left 左边界,right 右边界,upper 上边界 ,lower 下边界
        int left = 0,right = n-1,upper = 0 ,lower = n-1;
        int num = 1;
        while (num <= n*n){
            if(upper<=lower){
                // 先从上边界向右添加
                for (int i = left; i <= right; i++) {
                    result[upper][i] = num++;
                }
                // 上边界-1
                upper++;
            }
            if(left<=right){
                // 右边界向下添加
                for (int i = upper; i <= lower; i++) {
                    result[i][right] = num++;
                }
                // 右边界-1
                right--;
            }
            if(upper<=lower){
                // 下边界向左
                for (int i = right; i >= left ; i--) {
                    result[lower][i] = num++;
                }
                // 下边界+1
                lower--;
            }
            if(left<=right){
                // 左边界向上
                for (int i = lower; i >= upper ; i--) {
                    result[i][left] = num++;
                }
                // 左边界+1
                left++;
            }
        }
        return result;
    }

}
