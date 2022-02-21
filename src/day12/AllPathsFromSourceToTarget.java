package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * @date 2022/2/21
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        helper(graph,0,linkedList,result);
        return result;
    }

    private void helper(int[][] graph, int i,LinkedList<Integer> linkedList, List<List<Integer>> result) {
        // 添加当前节点为路径
        linkedList.addLast(i);
        // 说明到达最后
        if(i == graph.length - 1){
            // 添加结果
            result.add(new ArrayList<>(linkedList));
            // 删除最后
            linkedList.removeLast();
            return;
        }
        // 遍历所有
        for (int g : graph[i]) {
            helper(graph,g,linkedList,result);
        }
        // 用完就删掉
        linkedList.removeLast();
    }
}
