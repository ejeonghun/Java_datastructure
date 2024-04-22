package s240416;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTest0 {
    public static void main(String[] args) {

        String[] str={"나", "사", "아", "마", "바", "다", "라", "가"};

        System.out.println("정렬 전 : " + Arrays.toString(str)); // 배열 원소 출력

        Arrays.sort(str); // 오름차순 정렬(기본)
        System.out.println("오름차순 정렬 후 : "+ Arrays.toString(str));

        Arrays.sort(str, Collections.reverseOrder()); // 내림차순 정렬
        System.out.println("내림차순 정렬 후 : "+ Arrays.toString(str));
    }
}
