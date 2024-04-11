package s240409;

import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] x ={5, 3, 8, 4, 9, 1, 6, 2, 7};
        System.out.println("정렬 전 : " + Arrays.toString(x));
        quickSort(x, 0, x.length-1); // 퀵정렬 호출
        System.out.println("정렬 후 : " + Arrays.toString(x));
    }
    public static int partition(int[] arr, int low, int high) { // 분할 메소드
        int pivot = arr[low]; // 피봇 설정(첫번째 원소)
        int i = low + 1, j = high, temp;
        while (i < j) {
            while (i<high && arr[i] < pivot ) // 피봇보다 큰 원소 찾기
                i++;
            while (j>low && arr[j] > pivot) // 피봇보다 작은 원소 찾기
                j--;
            if (i < j) { // 두 원소 교환
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if ( arr[j] < arr[low] ){ // 피봇 위치를 가운데로 이동
            arr[low] = arr[j];
            arr[j] = pivot;
        }
        return j; // 피봇 최종위치 반환
    }
    public static void quickSort(int[] list, int low, int high) { // 퀵정렬 알고리즘(재귀호출)
        if(low<high) {
            int q=partition(list, low, high);
            quickSort(list, low, q-1);
            quickSort(list, q+1, high);
        }
    }
}