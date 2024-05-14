package s240514;

public class DFS추가실습4 {
    static int nE; // Edge 간선
    static int nV; // Vertex 정점
    static int[][] ad; // 인접 행렬 배열
    static boolean[] visit; // 방문 여부 체크
    static char[] adValue;

    public static void dfs(int i){
        visit[i] = true; // 함수 호출 시, visit 했음을 표시
        System.out.print(adValue[i]+ " ");

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
        adValue = new char[]{' ','A', 'B', 'C', 'D', 'E', 'F'};
        ad[1][2] = ad[2][1] = 1; // 간선들
        ad[1][3] = ad[3][1] = 1;
        ad[1][4] = ad[4][1] = 1;
        ad[2][5] = ad[5][2] = 1;
        ad[2][6] = ad[6][2] = 1;
        ad[3][6] = ad[6][3] = 1;

        System.out.print("DFS : ");
        dfs(1); // 1번부터 탐색 시작
    }
}