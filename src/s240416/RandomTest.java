package s240416;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
* 1~100사이의 임의의 정수 20개를 생성하여 배열에 저장한 후, 사용자
로부터 찾은 키 값을 입력받아 이진검색을 수행하는 프로그램을 작성하
시오.
*  */

class BinSearch {
    public static int binarySearch(int[] a, int key) { // 이진검색 알고리즘 반복문 구현
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // 중악위치 계산
            if (key < a[mid]) hi = mid - 1; // mid 오른쪽 범위 제거
            else if (key > a[mid]) lo = mid + 1; // lo 왼쪽 범위 제거
            else return mid;
        }
        return -1;
    }

    // 이진검색 알고리즘 재귀호출 구현
    public static int binarySearch(int[] a, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (target == a[middle]) {
            return middle;
        } else if (target < a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        } else {
            return binarySearch(a, middle + 1, end, target);
        }
    }
}

public class RandomTest {
    public static void main(String[] args) {
        Random rd = new Random();


        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100) + 1; // 1~100사이의 랜덤한 정수 생성
        }

        Arrays.sort(array);

        System.out.print("배열의 정보 {");
        for (int j = 0; j<array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println("}");
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 키 값을 입력해주세요. ");
        int key = sc.nextInt();
        System.out.printf("이진검색 결과 (%d 위치) : " + BinSearch.binarySearch(array, key) + "\n", key);

        System.out.println("찾을 키 값을 입력해주세요.");
        int key2 = sc.nextInt();

        System.out.printf("이진검색 결과 (%d 위치) : " + BinSearch.binarySearch(array,0, array.length-1 ,key2) , key2);

    }
}
