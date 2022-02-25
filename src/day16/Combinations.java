package day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * @date 2022/2/25
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,n,k,result,new LinkedList<>());
        return result;
    }

    private void helper(int start, int n, int k, List<List<Integer>> result, LinkedList<Integer> path) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            // i前面的都被遍历过了
            helper(i+1,n,k,result,path);
            path.removeLast();
        }
    }
}
