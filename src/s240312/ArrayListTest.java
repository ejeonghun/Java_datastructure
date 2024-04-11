package s240312;

import java.util.ArrayList;
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(); // 자바 ArrayList 객체 생성
        numbers.add(10); // 데이터 추가
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println("순차리스트(자바 ArrayList)");
        System.out.println(numbers); // 모든 데이터 출력
        numbers.add(1, 50); // 데이터 삽입
        System.out.println("\nadd(1, 50)");
        System.out.println(numbers);
        numbers.remove(2); // 데이터 삭제
        System.out.println("\nremove(2)");
        System.out.println(numbers);
        System.out.println("\nget(2)");
        System.out.println(numbers.get(2)); // 데이터 접근(읽기)
        System.out.println("\nsize()");
        System.out.println(numbers.size()); // 데이터 수 확인
        System.out.println("\nindexOf(30)");
        System.out.println(numbers.indexOf(30)); // 데이터 검색
        System.out.println("\nfor each문");
        for (int value : numbers) { // for each문으로 순차리스트 순회
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("\nfor문"); // for문으로 순차리스트 순회
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
