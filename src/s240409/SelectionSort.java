package s240409;

import java.util.Arrays;
public class SelectionSort {
    public static void selectionSort(int[] arr){ // 선택정렬 메소드

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) // i+1번째 최소값 찾기
                if (arr[j] < arr[index])
                    index = j;
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(String a[]){
        int[] arr1 = {5, 3, 8, 1, 2, 7};
        System.out.println("정렬 전 : " + Arrays.toString(arr1));
        selectionSort(arr1);
        System.out.println("정렬 후 : " + Arrays.toString(arr1));
    }
}