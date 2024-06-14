package s240521;

import java.util.*;
public class PrimMST {
    private static final int V = 7; // 정점 개수 7개로 설정
    // MST에 포함되지 않은 정점집합에서 최소 키 값을 가지는 정점 찾기
    int minKey(int dist[], Boolean Q[]) { // 최소 간선 인덱스 반환
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (Q[v] == false && dist[v] < min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    void printMST(int mst[], int graph[][]) { // MST 간선 출력
        System.out.println("MST 간선");
        for (int i = 0; i < V-1; i++)
            System.out.println(mst[i] + " -- " + mst[i+1] + " == "
                    + graph[mst[i]][mst[i+1]]);
    }
    void primMST(int graph[][]) { // 프림 알고리즘 메인 메소드
        int dist[] = new int[V]; // 최소 가중치 선택에 사용될 배열
        Boolean Q[] = new Boolean[V]; // MST 포함여부 체크 배열
        int mst[] = new int[V]; // MST 포함되는 정점을 순서대로 저장하는 배열
        for (int i = 0; i < V; i++) { // 모든 키 값을 무한대로 설정
            dist[i] = Integer.MAX_VALUE;
            Q[i] = false;
        }
        dist[0] = 0; // MST에 시작 정점 포함
        // MST에 V개의 정점이 포함될 때까지 반복
        for (int count = 0; count < V ; count++) {
            int u = minKey(dist, Q); // 최소 키 값 정점 선택
            Q[u] = true; // 선택 정점은 MST에 포함
            mst[count] = u;
            for (int v = 0; v < V; v++) // 인접 정점의 dist 값 업데이트
                if (graph[u][v] != 0 && Q[v] == false
                        && graph[u][v] < dist[v]) {
                    dist[v] = graph[u][v];
                }
        }
        printMST(mst, graph); // MST 간선 출력
        //System.out.println(Arrays.toString(mst));
    }
    public static void main(String[] args) {
        PrimMST t = new PrimMST();
        // 인접행렬로 표현된 가중치 그래프 초기화(입력)
        int[][] graph = { { 0, 28, 0, 0, 0, 10, 0 },
                { 28, 0, 16, 0, 0, 0, 14 },
                { 0, 16, 0, 12, 0, 0, 0 },
                { 0, 0, 12, 0, 22, 0, 18 },
                { 0, 0, 0, 22, 0, 25, 24 },
                { 10, 0, 0, 0, 25, 0, 0 },
                { 0, 14, 0, 18, 24, 0, 0 } };
        t.primMST(graph);
    }
}