package s240514;

public class DFS추가실습5 {
    static int nE; // Edge 간선
    static int nV; // Vertex 정점
    static int[][] ad; // 인접 행렬 배열
    static boolean[] visit; // 방문 여부 체크

    public static void dfs(int i){
        visit[i] = true; // 함수 호출 시, visit 했음을 표시
        System.out.print(i+ " ");

        for(int j = 0; j < nV; j++){
            if(ad[i][j] == 1 && visit[j] == false){ // j를 방문하지 않았으면 j를 방문
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        nV = 7;
        ad = new int[nV][nV]; // 변수 초기화
        visit = new boolean[nV]; // 변수 초기화

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


        System.out.print("DFS : ");
        dfs(0); // 0번부터 탐색 시작
    }
}