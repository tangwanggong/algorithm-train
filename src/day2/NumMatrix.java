package day2;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

    int[][] pre;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length,col = matrix[0].length;
        // 构建二维数据，提前计算所有从matrix[0][0] 到 [i-1][j-1]的和 ,pre[i][j] 代表 matrix[i-1][j-1] 到matrix[0][0]的和
        pre = new int[row+1][col+1];
        for (int i = 1; i < pre.length; i++) {
            for (int j = 1; j < pre[0].length; j++) {
                // 所以也就是 matrix[i-1][j-1](面积) + matrix[i-2][j-1](从[0][0]到所求面积右上位置的和) - matrix[i-1][j-2] (从[0][0]到所求面积左上位置的和) - matrix[i-2][j-2] (前两个重复的面积)
                pre[i][j] = matrix[i-1][j-1] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 所以也就是 matrix[row2][col2](总面积) - matrix[row1-1][col2](从[0][0]到所求面积右上位置的和) - matrix[row2][col1-1] (从[0][0]到所求面积左上位置的和) + matrix[row1-1][col1-1] (前两个重复的面积)
        return pre[row2+1][col2+1] - pre[row1][col2+1] - pre[row2+1][col1] + pre[row1][col1];
    }
}
