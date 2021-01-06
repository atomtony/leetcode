import java.util.LinkedList;
import java.util.Queue;

public class Ch31_Graph {


    static class Graph { // 无向图
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        public void bfs(int s, int t) {

            if (s == t) {
                return;
            }

            // 记录顶点是否被访问过
            boolean[] visited = new boolean[v];
            // 起始顶点标记为访问
            visited[s] = true;

            // 存储已经被访、但相连顶点还没有被访问的顶点
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            // 用来记录搜索路径，也就是第几层
            int[] prev = new int[v];
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }

            while (queue.size() != 0) {
                // 取出顶点
                int w = queue.poll();
                // 遍历与顶点w相连的其他顶点
                for (int i = 0; i < adj[w].size(); i++) {
                    int q = adj[w].get(i);

                    // 判断节点访问
                    if (!visited[q]) {
                        // 记录q顶点被w顶点访问
                        prev[q] = w;
                        // 判断q是否为t终点顶点，然后打印，退出循环
                        if (q == t) {
                            print(prev, s, t);
                            return;
                        }
                        // 记录q节点被访问
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        private void print(int[] prev, int s, int t) {
            // 递归打印访问t节点的上个节点
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }

    }

    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);

        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.addEdge(6, 7);
        graph.addEdge(5, 7);

        graph.bfs(0,7);

    }


}
