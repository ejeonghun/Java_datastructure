package s240416;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) { // 순차검색 메소드
        for (int index = 0; index <arr.length; index++)
            if (arr[index] == target)
                return index;
        return -1; // 찾고자 하는 데이터 없으면 -1 반환
    }
    public static void main(String[] args) {
        int[] arr = {1,9,7,3, 5,15,10, 37, 35, 17,23, 19, 20, 25,32,31}; // 찾고자 하는 데이터가 있으면 인덱스 반환되고, 없으면 -1 반환됨
        System.out.println("순차검색 결과 (23 위치) : " + linearSearch(arr, 23));
        System.out.println("순차검색 결과 (21 위치) : " + linearSearch(arr, 21));
    }
}