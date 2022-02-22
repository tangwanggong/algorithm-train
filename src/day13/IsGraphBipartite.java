package day13;

/**
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 * @date 2022/2/22
 */
public class IsGraphBipartite {
    // 当前是否为二分图
    private boolean ok = true;
    // 代表当前颜色
    private boolean[] color;
    // 代表当前路径已被访问
    private boolean[] visited;

    // 就是相邻两个图点颜色不同
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        color = new boolean[length];
        visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if(!visited[i]){
                helper(graph,i);
            }
        }
        return ok;
    }

    // dfs
    private void helper(int[][] graph, int num) {
        if(!ok){
            return;
        }
        visited[num] = true;
        for (int i : graph[num]) {
            // 如果访问过并且二者颜色相同，不符合二分图设定
            if(visited[i]){
                if(color[i] == color[num]){
                    ok = false;
                }
            }else {
                // 没访问过，就设置为和当前不同颜色
                color[i] = !color[num];
                // 接着dfs
                helper(graph,i);
            }
        }
    }
}
