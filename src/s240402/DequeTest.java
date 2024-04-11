package s240402;

import java.util.*;
public class DequeTest {
    public static void main(String args[]) {
        Deque<String> deque = new LinkedList<>(); // 데크 객체 생성
        deque.add("Java"); // 뒤에 추가 : add() == addLast() == offerLast() = offer()
        deque.addFirst("jQuery"); // 앞에 추가 : addFirst() == offerFirst()
        deque.addLast("HTML5"); // 뒤에 추가
        deque.offer("AngualarJS"); // 끝쪽에 추가
        deque.offerFirst("NodeJS"); // 앞쪽에 추가
        deque.offerLast("Javascript"); // 끝쪽에 추가
        System.out.println("데크 원소 : " + deque); // 데크 출력, deque.toString() 호출
        System.out.println("삭제전 첫번째 원소 : " + deque.getFirst());
        deque.removeFirst();// 앞에서 삭제 : removeFirst()==pollFirst()==poll()==remove()
        System.out.println("삭제후 첫번째 원소 : " + deque.peekFirst());
        System.out.println("삭제전 마지막 원소 : " + deque.getLast());
        deque.removeLast(); // 뒤에서 삭제 : removeLast()==pollLast()
        System.out.println("삭제후 마지막 원소 : " + deque.peekLast());
    }
}