package s240514;

import java.util.Scanner;

// 무방향 그래프를 인접 행렬로 표현

public class GraphTest1 {
    static int nE;
    static int nV;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt(); // Vertex (정점)
        nE = scan.nextInt(); // Edge (간선)
        // Vertex의 이름을 그대로 사용하기 위해 (nV+1)(nV+1)개만큼 배열 생성
        int[][] ad = new int[nV+1][nV+1];

        for(int i = 0; i < nE; i++){ // Edge 정보 입력 받음
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            ad[t1][t2] = ad[t2][t1] = 1; // 1대신 가중치를 넣으면 가중치 그래프
        }
    }
}
