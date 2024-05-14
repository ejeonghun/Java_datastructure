package s240514;

import java.util.*;

public class BFS추가실습5 {
    static int[][] ad; // 인접 행렬
    static boolean[] visit; // 방문체크 배열
    static int Nv = 7;
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>(); // 큐 생성
        q.offer(i);
        visit[i] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp+" ");
            for (int j = 0; j < Nv; j++)
                if (ad[temp][j] == 1 && visit[j] == false) {
                    q.offer(j);
                    // 큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
                    visit[j] = true;
                }
        }
    }

    public static void main(String[] args){
        ad = new int[Nv][Nv];
        visit = new boolean[Nv];

        // 인접 행렬로 그래프 표현(입력)
        ad[0][1] = ad[1][0] = 1;
        ad[0][5] = ad[5][0] = 1;
        ad[1][2] = ad[2][1] = 1;
        ad[1][6] = ad[6][1] = 1;
        ad[2][3] = ad[3][2] = 1;
        ad[3][4] = ad[4][3] = 1;
        ad[3][6] = ad[6][3] = 1;
        ad[4][5] = ad[5][4] = 1;
        ad[4][6] = ad[6][4] = 1;

        System.out.print("BFS : ");
        bfs(0);
    }
}
