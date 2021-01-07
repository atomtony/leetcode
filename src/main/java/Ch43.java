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
    }

    public static void main(String[] args) {

        // 0->2->4
        // 1->3->5
        // 6->3

        Graph graph = new Graph(7);
        graph.addEdge(0, 2);
        graph.addEdge(2, 4);

        graph.addEdge(1, 3);
        graph.addEdge(3, 5);

        graph.addEdge(6, 3);

        graph.topoSortByKahn();

    }

}
