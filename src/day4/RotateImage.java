package day4;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 如果n是双数,需要挪动(n/2)*(n/2)个组合,n是单数,需要挪动((n-1)/2)*((n+1)/2)个组合
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                // matrix[row][col] -> matrix[col][n-row-1] -> matrix[n-row-1][n-col-1] -> matrix[n-col-1][row] -> matrix[row][col]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
