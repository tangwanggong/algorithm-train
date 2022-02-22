package day13;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/possible-bipartition/
 * @date 2022/2/22
 */
public class PossibleBipartition {
    // 当前是否为二分图
    private boolean ok = true;
    // 代表当前颜色
    private boolean[] color;
    // 代表当前路径已被访问
    private boolean[] visited;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n+1];
        visited = new boolean[n+1];
        List<Integer>[] graph = buildGraph(n,dislikes);
        for (int i = 1; i <= n; i++) {
            helper(graph,i);
        }
        return ok;
    }

    // 判断是否为二分图
    private void helper(List<Integer>[] graph, int num) {
        if(!ok){
            return;
        }
        visited[num] = true;
        for (Integer n : graph[num]) {
            if(visited[n]){
                if(color[n] == color[num]){
                    ok = false;
                }
            }else {
                color[n] = !color[num];
                helper(graph,n);
            }
        }
    }

    // 构建图
    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] result = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = new LinkedList<>();
        }
        // 写图,二者关系是双向连接的
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            result[a].add(b);
            result[b].add(a);
        }
        return result;
    }
}
