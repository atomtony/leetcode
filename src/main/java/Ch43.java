import java.util.LinkedList;

public class Ch43 {

    static class Graph {
        private int v;//顶点个数
        private LinkedList<Integer> adj[];//领接表

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            adj[s].add(t);
        }

        // Kahn 算法
        public void topoSortByKahn() {
            int[] inDegree = new int[v];//统计每个顶点的入度
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    // 连接顶点
                    int w = adj[i].get(j);
                    // 连接顶点入度加1
                    inDegree[w]++;
                }
            }

            // 记录起始顶点
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if (inDegree[i] == 0) {
                    // 入度为0,属于起始顶点
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                // 起始顶点
                int i = queue.remove();
                System.out.print("->" + i);

                // 遍历起始顶点连接的其他顶点
                for (int j = 0; j < adj[i].size(); j++) {
                    // 连接点
                    int k = adj[i].get(j);
                    // 起始点已经输出，连接点入度减1
                    inDegree[k]--;
                    // 连接点入度为0,则变成了起始顶点
                    if (inDegree[k] == 0) {
                        queue.add(k);
                    }
                }
            }
        }

        // DFS 算法
        public void topoSortByDFS() {
            // 逆邻接表
            LinkedList<Integer> inverseAdj[] = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                inverseAdj[i] = new LinkedList<>();
            }

            // 通过领接表创建逆邻接表
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j); // i->w
                    inverseAdj[w].add(i);// w->i
                }
            }

            // 记录顶点访问标记
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    // 标记访问标记
                    visited[i] = true;
                    // 深度优先搜索
                    dfs(i, inverseAdj, visited);
                }
            }
        }

        public void dfs(int vertext, LinkedList<Integer> inverseAdj[], boolean[] visited) {
            // 遍历逆邻接表
            for (int i = 0; i < inverseAdj[vertext].size(); i++) {
                // w->i
                int w = inverseAdj[vertext].get(i);
                if (visited[w]) {
                    continue;
                }
                visited[w] = true;
                // 递归访问前驱顶点
                dfs(w, inverseAdj, visited);
            }
            System.out.print("->" + vertext);
        }

    }


    public static void main(String[] args) {

        Graph graph = new Graph(7);

        // 0->2->4
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);

        // 1->3->5
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);

        // 6->3
        graph.addEdge(6, 3);

        // Kahn算法 测试
        graph.topoSortByKahn();

        System.out.println();

        // DFS算法 测试
        graph.topoSortByDFS();

    }

}
