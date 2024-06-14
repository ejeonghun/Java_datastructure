package s240604;

import java.util.*;

/*
* 연습문제 5 해결
         0  1  2  3  4  5  6
dist[] = 0 11  7 19  3 19  37
path[] = 0  0  4  4  0  2   5
* */
public class 추가실습2 {
    static int nV = 7; // 정점 개수 : 7
    static final int inf = 1000000; // 가중치 ∞ 값 설정
    // 인접행렬로 표현된 가중치 그래프(입력)
    static int[][] ad = { { 0, 11, 9, inf, 3, inf, inf },
            { 11, 0, inf, inf, 6, inf, 30 },
            { 9, inf, 0, inf, 19, 12, inf },
            { inf, inf, inf, 0, inf, inf, 21 },
            { inf, inf, 4, 16, 0, 21, 44 },
            { inf, inf, inf, inf, inf, 0, 18 },
            { inf, inf, inf, inf, inf, inf, inf } };
    static int[] dist = new int[nV]; // 최단거리 저장 배열
    static boolean[] visit = new boolean[nV]; // 방문 체크 배열
    static int[] path = new int[nV]; // 최단경로 저장 배열
    public static void shortestPath(int start){
        dist[start] = 0;

        for( int j = 0; j < nV; j++)
        {
            int min = inf+1;
            int index = -1;
            // 시작정점에서 거리가 가장 작은 정점의 인덱스 파악
            for(int k = 0; k < nV; k++){
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            visit[index] = true;

            // 최단거리, 경로 업데이트
            for(int l = 0; l < nV; l++)
                if(ad[index][l] != 0 && dist[l] > dist[index] + ad[index][l]) {
                    dist[l] = dist[index] + ad[index][l];
                    path[l] = index; // 경로 업데이트
                }
        }
        // 시작정점에서 각 정점까지 최단거리 출력
        System.out.print("dist[] : ");
        for (int i = 0; i < nV; i++)
            System.out.print(dist[i] + " ");
        System.out.println();
        // 시작정점에서 각 정점까지 최단경로 출력에 활용되는 path[] 배열 출력
        System.out.print("path[] : ");
        for (int i = 0; i < nV; i++)
            System.out.print(path[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        for (int i = 0; i < nV; i++)
            dist[i] = inf;
        shortestPath(0);
    }
}