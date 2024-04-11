package s240402;

public class test1 {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(6); // 원형 큐 객체 생성
        for(int i=1; i<=5; i++) // 큐에 삽입
            q.enQueue(i); System.out.print("원형큐 출력 : ");
        for(int i=1; i<=4; i++) // 큐에서 삭제
            System.out.print(q.deQueue() + " ");
        for(int i=6; i<=7; i++) {
            q.enQueue(i);
            System.out.print("원형큐 출력 : ");
        }
        q.print();
    }
}
