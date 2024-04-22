package s240416;

import java.util.*;
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(); // 리스트 객체 생성
        for (int i = 1; i <= 10; i++) // 정수 객체 1~10 추가
            list.add(i);
        Collections.shuffle(list); // 셔플 수행
        System.out.println("셔플 결과 : " + list);
        Collections.sort(list); // 정렬 수행
        System.out.println("정렬 : " + list);

        int key = 9; // 찾은 키
        int index = Collections.binarySearch(list, key); // 이진검색 수행
        System.out.println("키값 9 탐색 결과 : " + index);
    }
}