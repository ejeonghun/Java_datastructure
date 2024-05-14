package s240507;

import java.util.*;
public class PriorityQueueTest2 {
    public static void main(String[] args) {
        // 정수객체를 저장하는 우선순위큐 객체 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        // reverseOrder로 내림차순으로 정렬되도록 설정
        int[] arr = {3, 1, 9, 5, 7};

        // arr의 정수를 입력
        for (int i = 0; i<arr.length; i++ )
            pq.add (arr[i]) ;

        System.out.println ("힙 상태 : "+ pq);

        System.out.print("내림차순정렬 : ");
        for(int i=0; i<arr.length; i++)
            System.out.print(pq.remove() + " ");
    }
    /*
                 9
                / \
               7   3
              / \
             1   5
    * */
}
