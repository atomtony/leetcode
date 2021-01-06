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

        public void topoSortByKahn() {
            int[] inDegree = new int[v];//统计每个顶点的入度
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j);
                    inDegree[w]++;
                }
            }

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
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

    }

}
