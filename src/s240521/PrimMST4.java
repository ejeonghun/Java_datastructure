package s240521;

import java.util.Arrays;

// 4번 문제 프림 알고리즘으로 구현

public class PrimMST4 {
    private static final int V = 7; // 정점 개수 7개로 설정
    // MST에 포함되지 않은 정점집합에서 최소 키 값을 가지는 정점 찾기
    int minKey(int dist[], Boolean Q[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!Q[v] && dist[v] < min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    void printMST4(int mst[], int graph[][]) {
        System.out.println("MST 간선");
        for (int i = 1; i < V; i++) {
            System.out.println((mst[i] + 1) + " - " + (i+1) + "    " + graph[mst[i]][i]);
        }
    }
    void primMST4(int graph[][]) { // 프림 알고리즘 메인 메소드
        int dist[] = new int[V]; // 최소 가중치 선택에 사용될 배열
        Boolean Q[] = new Boolean[V]; // MST 포함여부 체크 배열
        int mst[] = new int[V]; // MST 포함되는 정점을 순서대로 저장하는 배열
        for (int i = 0; i < V; i++) { // 모든 키 값을 무한대로 설정
            dist[i] = Integer.MAX_VALUE;
            Q[i] = false;
        }
        dist[0] = 0; // MST에 시작 정점 포함
        mst[0] = -1; // 첫번째 정점은 항상 MST의 루트가 됨
        // MST에 V개의 정점이 포함될 때까지 반복
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(dist, Q); // 최소 키 값 정점 선택
            Q[u] = true; // 선택 정점은 MST에 포함
            for (int v = 0; v < V; v++) // 인접 정점의 dist 값 업데이트
                if (graph[u][v] != 0 && Q[v] == false && graph[u][v] < dist[v]) {
                    mst[v] = u;
                    dist[v] = graph[u][v];
                }
        }
        printMST4(mst, graph); // MST 간선 출력
    }
    public static void main(String[] args) {
        PrimMST4 t = new PrimMST4();
        // 인접행렬로 표현된 가중치 그래프 초기화(입력)
        int[][] graph = {
                { 0, 2, 4, 1, 0, 0, 0 },
                { 2, 0, 0, 3, 10, 0, 0 },
                { 4, 0, 0, 2, 0, 5, 0 },
                { 1, 3, 2, 0, 7, 8, 4 },
                { 0, 10, 0, 7, 0, 0, 6 },
                { 0, 0, 5, 8, 0, 0, 1 },
                { 0, 0, 0, 4, 6, 1, 0 }
        };
        t.primMST4(graph);
    }
}
