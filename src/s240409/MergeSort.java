package s240409;

import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 27, 10, 12, 20, 25, 13, 15, 22 };
        System.out.println("정렬 전 : " + Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println("정렬 후 : " + Arrays.toString(a));
    }
    public static void mergeSort(int[] a, int low, int high) { // 합병정렬 메소드(재귀호출)
        if (low < high) {
            // 중간위치 계산
            int middle = low + (high - low) / 2;
            // 왼쪽 리스트 합병정렬(재귀호출)
            mergeSort(a, low, middle);
            // 오른쪽 리스트 합병정렬(재귀호출)
            mergeSort(a, middle + 1, high);
            // 두 리스트 합병
            merge(a, low, middle, high);
        }
    }
    // 두 리스트 합병, [low, middle] + [middle+1, high] => [low, high]
    public static void merge(int[] a, int low, int middle, int high) { // 합병 메소드

        int[] sorted = new int[a.length];
        int number;
        // sorted 배열로 복사
        for (int i = low; i <= high; i++) {
            sorted[i] = a[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        // 두 리스트의 원소 중 더 작은 원소를 sorted 배열로 복사
        while (i <= middle && j <= high) {
            if (sorted[i] <= sorted[j]) {
                a[k] = sorted[i];
                i++;
            } else {
                a[k] = sorted[j];
                j++;
            }
            k++;
        }
        // 나머지 원소를 sorted 배열로 복사
        while (i <= middle) {
            a[k] = sorted[i];
            k++;
            i++;
        }

        // 두 번째 리스트의 남은 원소를 sorted 배열로 복사
        while (j <= high) {
            a[k] = sorted[j];
            k++;
            j++;
        }
    }
}