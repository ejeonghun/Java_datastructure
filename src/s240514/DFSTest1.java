package s240514;

public class DFSTest1 {

    static int nE;
    static int nV;
    static int[][] ad;
    static boolean[] visit; // 방문 여부 체크
    public static void dfs(int i){
        visit[i] = true; // 함수 호출 시, visit 했음을 표시
        System.out.print(i+ " ");

        for(int j = 1; j < nV+1; j++){
            if(ad[i][j] == 1 && visit[j] == false){ // j를 방문하지 않았으면 j를 방문
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        nV = 6;
        ad = new int[nV+1][nV+1]; // 변수 초기화
        visit = new boolean[nV+1]; // 변수 초기화

        // 인접 행렬로 그래프 표현(입력)
        ad[1][5] = ad[5][1] = 1; // 간선들
        ad[1][6] = ad[6][1] = 1;
        ad[2][3] = ad[3][2] = 1;
        ad[2][4] = ad[4][2] = 1;
        ad[2][6] = ad[6][2] = 1;
        ad[3][4] = ad[4][3] = 1;
        ad[3][5] = ad[5][3] = 1;
        ad[5][6] = ad[6][5] = 1;

        System.out.print("DFS : ");
        dfs(1); // 1번부터 탐색 시작
    }
}
