package s240514;

import java.util.*;

// 무방향 그래프를 인접 리스트로 표현
public class GraphTest2 {
    static int nV; // 총 vertex 개수
    static int nE; // 총 edge 개
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        nV = scan.nextInt();
        nE = scan.nextInt();
        // 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> ad = new ArrayList<>();

        for(int i = 0; i < nV; i++) { // 정점 개수만큼 ArrayList 생성
            ad.add(new<Integer> ArrayList()); // ad 리스트에 담을 리스트 초기화
        }
        for(int i = 0; i < nE; i++) {
            int t1, t2; // vertex 두 개 입력 받기
            t1 = scan.nextInt(); // 좌우 대칭 쌍으로 입력
            t2 = scan.nextInt(); // 좌우 대칭 쌍으로 입력
            ad.get(t1).add(t2); // 양방향 그래프이므로, vertex 1, 2 값 초기화
            ad.get(t2).add(t1);
        }
    }
}

