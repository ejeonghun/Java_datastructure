package s240402;

import java.util.*;
public class QueueTest1 {
    public static void main(String args[]) {
        Queue<String> queue = new LinkedList<>(); // 큐로 사용할 LinkedList 객체생성
        queue.offer("one"); // 큐에 데이터 추가
        queue.offer("two");
        queue.offer("three");
        System.out.print("자바 큐 출력 : ");
        while (!queue.isEmpty()) {
            String str = queue.poll(); // 큐의 데이터를 가져와 출력
            System.out.print(str + " ");
        }
    }
}