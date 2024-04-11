package s240402;

class LinearQueue { // 선형 큐 클래스 정의
    Integer data[];
    int front;
    int rear;
    int size;
    LinearQueue(int maxSize) { // 생성자, maxSize 크기의 배열 생성
        data = new Integer[maxSize];
        front = -1;
        rear = -1;
        size = maxSize;
    }
    public void enQueue(Integer elem) { // 큐 삽입 연산
        rear = rear + 1;
        data[rear] = elem;
    }
    public Integer deQueue() { // 큐 삭제 연산
        Integer retval;
        if (front == rear) // 만약 front와 rear가 똑같다면 큐가 비어있는 것
            return null;
        front = front + 1;
        return data[front];
    }
    public Integer peek() { // 큐 조회 연산
        Integer retval;
        if (front == rear)
            return null;
        return data[front+1];
    }
    public boolean empty() { // 공백상태 확인
        return front == rear;
    }
    public boolean full() { // 포화상태 확인
        return rear == size-1;
    }
}
public class LinearQueueTest {
    public static void main(String[] args){
        LinearQueue q = new LinearQueue(10); // 크기 10인 선형 큐 생성
        for(int i=1; i<=5; i++) // 큐에 삽입
            q.enQueue(i);
        System.out.print("배열큐 출력 : ");
        for(int i=1; i<=5; i++) // 큐에서 삭제
            System.out.print(q.deQueue() + " ");
    }
}