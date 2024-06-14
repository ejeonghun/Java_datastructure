package s240521;
import java.util.*;

/*
* 추가 실습 : 인접 행렬로 초기화(변환) : 7*7 배열 필요
* */

class Graph_인접행렬 {
    int V;
    int[][] matrix;

    Graph_인접행렬(int v) {
        V = v;
        matrix = new int[V][V];
        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++)
                matrix[i][j] = Integer.MAX_VALUE;
    }

    void addEdge(int src, int dest, int weight) {
        matrix[src][dest] = weight;
        matrix[dest][src] = weight;
    }

    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[yroot] = xroot;
    }

    void KruskalMST() {
        int parent[] = new int[V];
        for (int i = 0; i < V; ++i)
            parent[i] = i;


        System.out.println("인접행렬");

        for (int k = 0; k < V * V; ++k) {
            int min = Integer.MAX_VALUE, x = -1, y = -1;
            for (int i = 0; i < V; ++i) {
                for (int j = 0; j < V; ++j) {
                    if (find(parent, i) != find(parent, j) && matrix[i][j] < min) {
                        min = matrix[i][j];
                        x = i;
                        y = j;
                    }
                }
            }

            if(x != -1 && y != -1) {
                System.out.printf("%d -- %d == %d \n",  x, y, min);
                union(parent, x, y);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        Graph_인접행렬 graph = new Graph_인접행렬(V);

        graph.addEdge(0, 1, 28);
        graph.addEdge(0, 5, 10);
        graph.addEdge(1, 2, 16);
        graph.addEdge(1, 6, 14);
        graph.addEdge(2, 3, 12);
        graph.addEdge(3, 4, 22);
        graph.addEdge(3, 6, 18);
        graph.addEdge(4, 5, 25);
        graph.addEdge(4, 6, 24);

        graph.KruskalMST();
    }
}
