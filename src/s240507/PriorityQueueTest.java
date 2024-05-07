package s240507;

import java.util.*;
public class PriorityQueueTest {
    public static void main(String[] args) {
        // 정수객체를 저장하는 우선순위큐 객체 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1~10까지의 정수를 입력
        for (int i=10; i>=1; i-- )
            pq.add (new Integer (i)) ;

        System.out.println ("힙 상태 : "+ pq);

        //우선순위 큐에서 가장 작은 숫자를 추출
        Integer root = pq.peek();
        System.out.println ( "루트 값 : "+ root);
    }
    /*
    *           1
    *       2       5
    *    4     3  9    6
    *  10  7  8
    * */
}