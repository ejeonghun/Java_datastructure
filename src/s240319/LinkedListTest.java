package s240319;

import java.util.LinkedList;
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>(); // 자바 LinkedList 객체 생성
        list.add("포도"); // 리스트에 데이터 추가
        list.add("딸기");
        list.add("복숭아");
        list.add(2, "키위"); // 리스트에 데이터 삽입
        list.set(0, "오렌지"); // 리스트 데이터 변경
        System.out.println("삭제 전 : " + list);
        list.remove(1); // 리스트에서 데이터 삭제
        list.remove("키위");
        System.out.println("삭제 후 : " + list); // 리스트 전체 데이터 출력
        int num = list.size(); // 리스트 전체 데이터 개수
        System.out.print("역순 출력 : ");
        for (int cnt =num-1; cnt >= 0; cnt--) {
            String str = list.get(cnt); // 특정 위치 데이터 검색
            System.out.print(str + " ");
        }
    }
}