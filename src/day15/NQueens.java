package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * @date 2022/2/25
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] queens = new char[n][n];
        for (char[] queen : queens) {
            Arrays.fill(queen,'.');
        }
        helper(0,queens,result);
        return result;
    }

    private void helper(int row,char[][] queens , List<List<String>> result) {
        // 代表queens的每行都有queen了
        if(row == queens.length){
            result.add(generateQueens(queens));
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            // 是否合法
            if(!isValid(queens,row,i)){
                continue;
            }
            // 回溯
            queens[row][i] = 'Q';
            helper(row+1,queens,result);
            queens[row][i] = '.';
        }
    }

    private boolean isValid(char[][] queens,int row,int col){
        // 正上方
        for (int i = 0; i < row; i++) {
            if(queens[i][col] == 'Q'){
                return false;
            }
        }
        // 左上方
        for (int i = row-1,j =col-1 ; i >=0 && j>=0; i--,j--) {
            if(queens[i][j] == 'Q'){
                return false;
            }
        }
        // 右上方
        for (int i = row-1,j =col+1 ; i >=0 && j<queens.length; i--,j++) {
            if(queens[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    // 生成皇后
    private List<String> generateQueens(char[][] chars){
        List<String> result = new ArrayList<>();
        for (char[] c : chars) {
            result.add(new String(c));
        }
        return result;
    }
}
