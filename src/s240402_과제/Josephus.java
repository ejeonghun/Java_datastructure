package s240402_과제;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<= 100; i++) {
            q.offer(i); // 해당 큐 맨뒤에 값 삽입
        } // 1~ 20까지 Queue 생성

        int count = 0;
        while(q.size() > 2) {
            ++count;
            if(count == 3) {
                count = 0;
                q.poll(); // 맨 앞에 있는 값 반환 후 삭제
                continue;
            }
            q.offer(q.poll());
        }

        System.out.print("최후의 2인은? : ");
        for(int i = 0; i<=q.size(); i++) {
            System.out.print(q.poll() + " ");
        }
    }
}