package s240604;

import java.util.*;

public class 추가실습1 {
    static int nV = 7; // 정점 개수
    static final int inf = 1000000; // 가중치 무한대 값 설정
    // 인접 행렬로 표현된 가중치 그래프
    static int[][] ad = {
            { 0, 2, inf, inf, 5, inf, inf }, // 정점 0의 간선들
            { 2, 0, 3, 8, 1, inf, inf },     // 정점 1의 간선들
            { inf, 3, 0, 1, inf, inf, 4 },   // 정점 2의 간선들
            { inf, 8, 1, 0, 5, 1, 5 },       // 정점 3의 간선들
            { 5, 1, inf, 5, 0, inf, inf },   // 정점 4의 간선들
            { inf, inf, inf, 1, inf, 0, 1 }, // 정점 5의 간선들
            { inf, inf, 4, 5, inf, 1, 0 }    // 정점 6의 간선들
    };
    static int[] dist = new int[nV]; // 최단 거리 저장 배열
    static boolean[] visit = new boolean[nV]; // 방문 체크 배열
    static int[] path = new int[nV]; // 최단 경로 저장 배열

    public static void shortestPath(int start) {
        dist[start] = 0; // 시작 정점에서 자신까지의 거리는 0

        for (int j = 0; j < nV; j++) { // 모든 정점에 대해 반복
            int min = inf + 1;
            int index = -1;

            // 방문하지 않은 정점 중에서 가장 작은 거리를 가진 정점 찾기
            for (int k = 0; k < nV; k++) {
                if (!visit[k] && min > dist[k]) {
                    min = dist[k];
                    index = k;
                }
            }

            if (index == -1) break; // 더 이상 접근할 수 없는 정점이 없으면 종료

            visit[index] = true; // 해당 정점을 방문한 것으로 표시

            // 인접한 정점들의 거리 갱신
            for (int l = 0; l < nV; l++) {
                if (ad[index][l] != inf && !visit[l] && dist[l] > dist[index] + ad[index][l]) {
                    dist[l] = dist[index] + ad[index][l]; // 거리 갱신
                    path[l] = index; // 경로 갱신
                }
            }
        }


        // 시작 정점에서 각 정점까지의 최단 경로 출력
        for (int i = 0; i < nV; i++) {
            System.out.print("0 - " + i + " 최단 경로 : ");
            printPath(i);
            System.out.println();
        }
    }

    // 주어진 도착 정점까지의 경로를 출력하는 메서드
    public static void printPath(int end) {
        if (dist[end] == inf) { // 도착 정점이 접근 불가능한 경우
            System.out.print("경로 없음"); // "경로 없음" 출력
            return;
        }

        Stack<Integer> stack = new Stack<>(); // 경로를 저장할 스택
        for (int at = end; at != -1; at = path[at]) { // 경로 배열을 역추적
            stack.push(at); // 정점을 스택에 저장
        }

        // 스택에서 정점을 꺼내어 올바른 순서로 경로 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) System.out.print(" - ");
        }
    }

    public static void main(String[] args) {
        Arrays.fill(dist, inf); // 거리 배열을 무한대로 초기화
        Arrays.fill(path, -1); // 경로 배열을 -1로 초기화 (경로 없음)
        shortestPath(0); // 0번 정점에서 시작하는 최단 경로 계산
    }
}
