package s240416;

public class BinarySearch {
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
        if(end < start) {
            return -1;
        }
        if(target==a[middle]) {
            return middle;
        } else if(target<a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        } else {
            return binarySearch(a, middle + 1, end, target);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,10,15,17,19,20,23,25,31,32,35,37}; // 정렬된 데이터
        // 찾고자 하는 데이터가 있으면 인덱스 반환
        System.out.println("이진검색 결과 (23 위치) : " + binarySearch(arr, 23));
        System.out.println("이진검색 결과 (9 위치) : " + binarySearch(arr, 0, arr.length-1, 9));
    }
}
