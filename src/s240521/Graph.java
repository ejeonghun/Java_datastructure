package s240521;

import java.util.*;
class Graph { // Comparable 인터페이스를 사용한다는 의미는 크기 비교 가능한 객체
    class Edge implements Comparable<Edge> { // 간선 클래스
        int src, dest, weight; // 두 정점과 가중치
        public int compareTo(Edge compareEdge) { // 가중치로 크기 비교
            return this.weight - compareEdge.weight;
        }
    }
    class subset { // union-find 연산에 사용되는 부분집합 클래스
        int parent, rank;
        public String toString() {
            return String.format("P:%d,R:%d", parent, rank);
        }
    }
    int V, E; // 정점 개수와 간선 개수
    Edge edge[]; // 간선 객체 배열
    Graph(int v, int e) { // 그래프 객체 생성자
        V = v;
        E = e;
        edge = new Edge[E]; // 간선 객체 배열 생성
        for (int i=0; i<e; ++i)
            edge[i] = new Edge(); // 간선 객체 생성
    }
    int find(subset subsets[], int i) { // i 원소의 집합을 찾는 메소드
        if (subsets[i].parent != i)
            return find(subsets, subsets[i].parent);
        else
            return i;
    }
    void Union(subset subsets[], int xroot, int yroot) { // 두 집합을 union 연산하는 메소드
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
            subsets[yroot].rank += subsets[xroot].rank;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank += subsets[yroot].rank;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank += subsets[yroot].rank;
        }
    }
    void KruskalMST() { // 크루스칼 알고리즘을 구현하는 메인 메소드
        Edge result[] = new Edge[V];
        int e = 0, i = 0;

        Arrays.sort(edge); // 간선 객체 배열을 오름차순 정렬
        subset subsets[] = new subset[V];

        for(i=0; i<V; ++i)
            subsets[i]=new subset(); // 부분 집합 객체 생성
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 1;
        }
        // System.out.println(Arrays.toString(subsets));
        i = 0;
        while (e < V - 1) { // 간선의 수가 V-1 될 때까지 반복
            Edge next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) { // 사이클을 만들지 않으면 간선 포함, 두 부분 집합 union
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // System.out.println(Arrays.toString(subsets));
        }
        System.out.println("MST 간선 ");
        for (i = 0; i < e; ++i) // MST에 포함되는 간선 출력
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                    result[i].weight);
    }
    public static void main (String[] args) {
        int V = 7;
        int E = 9;
        Graph graph = new Graph(V, E);
        // 간선 객체 초기화
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 28;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 5;
        graph.edge[1].weight = 10;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 16;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 6;
        graph.edge[3].weight = 14;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 12;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 22;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 6;
        graph.edge[6].weight = 18;

        graph.edge[7].src = 4;
        graph.edge[7].dest = 5;
        graph.edge[7].weight = 25;

        graph.edge[8].src = 4;
        graph.edge[8].dest = 6;
        graph.edge[8].weight = 24;
        graph.KruskalMST();
    }
}
