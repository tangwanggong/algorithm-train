package day4;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @date 2022/2/14
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // left 左边界,right 右边界,upper 上边界 ,lower 下边界
        int left = 0,right = n-1,upper = 0 ,lower = m-1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < m * n){
            if(upper<=lower){
                // 先从上边界向右添加
                for (int i = left; i <= right; i++) {
                    result.add(matrix[upper][i]);
                }
                // 上边界-1
                upper++;
            }
            if(left<=right){
                // 右边界向下添加
                for (int i = upper; i <= lower; i++) {
                    result.add(matrix[i][right]);
                }
                // 右边界-1
                right--;
            }
            if(upper<=lower){
                // 下边界向左
                for (int i = right; i >= left ; i--) {
                    result.add(matrix[lower][i]);
                }
                // 下边界+1
                lower--;
            }
            if(left<=right){
                // 左边界向上
                for (int i = lower; i >= upper ; i--) {
                    result.add(matrix[i][left]);
                }
                // 左边界+1
                left++;
            }
        }
        return result;
    }
}
