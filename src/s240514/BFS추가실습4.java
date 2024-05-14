package s240514;

import java.util.*;

public class BFS추가실습4 {
    static int[][] ad; // 인접 행렬
    static boolean[] visit; // 방문체크 배열
    static int Nv = 6;
    static char[] Vertexs;
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>(); // 큐 생성
        q.offer(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(Vertexs[temp]+" ");
            for (int j = 1; j <= Nv; j++)
                if (ad[temp][j] == 1 && visit[j] == false) {
                    q.offer(j);
                    // 큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
                    visit[j] = true;
                }
        }
    }

    public static void main(String[] args){
        ad = new int[Nv+1][Nv+1];
        visit = new boolean[Nv+1];

        // 인접 행렬로 그래프 표현(입력)
        Vertexs = new char[]{' ','A', 'B', 'C', 'D', 'E', 'F'};
        ad[1][2] = ad[2][1] = 1; // 간선들
        ad[1][3] = ad[3][1] = 1;
        ad[1][4] = ad[4][1] = 1;
        ad[2][5] = ad[5][2] = 1;
        ad[2][6] = ad[6][2] = 1;
        ad[3][6] = ad[6][3] = 1;

        System.out.print("BFS : ");
        bfs(1);
    }
}
