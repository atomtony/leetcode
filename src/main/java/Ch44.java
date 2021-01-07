import java.util.LinkedList;

public class Ch44 {

    // 边
    static class Edge {
        int sid;
        int tid;
        int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 顶点
    static class Vertex {
        int id;// 顶点编号 ID
        int dist; // 从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    // 小顶堆
    static class PriorityQueue {
        Vertex[] nodes;
        int n;
        int count;

        public PriorityQueue(int v) {
            this.n = v;
            this.nodes = new Vertex[v + 1];
            this.count = 0;
        }

        public Vertex poll() {
            if (count == 0) {
                return null;
            }
            // 堆顶元素
            Vertex ret = nodes[1];

            // 将最后一个元素放到堆顶
            nodes[1] = nodes[count];
            // 元素数减1
            count--;
            // 自上而下建堆,小堆
            heapify(nodes, count, 1);
            return ret;
        }

        private static void heapify(Vertex[] nodes, int cout, int i) {
            while (true) {
                int minPos = i;
                // 左节点小于当前节点
                if (i * 2 <= cout && nodes[i].dist > nodes[i * 2].dist) {
                    minPos = i * 2;
                }

                if (i * 2 + 1 <= cout && nodes[minPos].dist > nodes[i * 2 + 1].dist) {
                    minPos = i * 2 + 1;
                }

                // 当前节点最小
                if (minPos == i) {
                    return;
                }

                // 交换当前节点和左右节点较小的那个
                swap(nodes, i, minPos);

                // 记录较小那个字节点为当前 节点
                i = minPos;
            }
        }

        private static <T> void swap(T[] a, int index1, int index2) {
            T tmp = a[index1];
            a[index1] = a[index2];
            a[index2] = tmp;
        }


        public void add(Vertex vertex) {
            if (count >= n) {
                return;
            }
            ++count;
            nodes[count] = vertex;
            int i = count;
            while (i / 2 > 0 && nodes[i].dist < nodes[i / 2].dist) {
                swap(nodes, i, i / 2);
                i = i / 2;
            }
        }

        public void update(Vertex vertex) {

            int findIndex = 0;
            for (int i = 1; i <= count; i++) {
                if (vertex == nodes[i]) {
                    findIndex = i;
                    break;
                }
            }

            while (findIndex / 2 > 0 && nodes[findIndex].dist < nodes[findIndex / 2].dist) {
                swap(nodes, findIndex, findIndex / 2);
                findIndex = findIndex / 2;
            }
        }

        public boolean isEmpty() {
            return count == 0;
        }

    }


    static class Graph {
        private LinkedList<Edge> adj[];// 邻接表
        private int v;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) {//添加一条边
            adj[s].add(new Edge(s, t, w));
        }

        public void dijkstra(int s, int t) {
            //用来还远最短路径
            int[] predecessor = new int[this.v];
            Vertex[] vertices = new Vertex[this.v];

            for (int i = 0; i < this.v; i++) {
                vertices[i] = new Vertex(i, Integer.MAX_VALUE);
            }

            PriorityQueue queue = new PriorityQueue(this.v);
            // 比较是否进入过队列
            boolean[] inqueue = new boolean[this.v];
            vertices[s].dist = 0;

            queue.add(vertices[s]);
            inqueue[s] = true;

            while (!queue.isEmpty()) {
                // 取堆顶元素并删除
                Vertex minVertex = queue.poll();
                if (minVertex.id == t) {
                    break;//短路径产生了
                }

                for (int i = 0; i < adj[minVertex.id].size(); i++) {
                    // 取出一条minVetex相连的边
                    Edge e = adj[minVertex.id].get(i);
                    //  下一个顶点
                    Vertex nextVertex = vertices[e.tid];
                    //  最小顶点的距离，加上边的权重，下一个顶点的到起始点的距离
                    if (minVertex.dist + e.w < nextVertex.dist) {
                        // 跟新
                        nextVertex.dist = minVertex.dist + e.w;
                        predecessor[nextVertex.id] = minVertex.id;
                        if (inqueue[nextVertex.id]) {
                            queue.update(nextVertex);
                        } else {
                            queue.add(nextVertex);
                            inqueue[nextVertex.id] = true;
                        }
                    }
                }
            }

            System.out.print(s);
            print(s, t, predecessor);
        }

        private void print(int s, int t, int[] predecessor) {
            if (s == t) {
                return;
            }
            print(s, predecessor[t], predecessor);
            System.out.println("->" + t);
        }


    }


    public static void main(String[] args) {

    }
}
