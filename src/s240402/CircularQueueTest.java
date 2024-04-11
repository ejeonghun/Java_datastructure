package s240402;

class CircularQueue{ // 원형 큐 클래스 정의
    private int front;
    private int rear;
    private int queueSize; // 큐 크기
    private int ItemArray[];
    public CircularQueue(int queueSize) { // 생성자, queueSize 크기의 배열 생성
        this.front = 0;
        this.rear = 0;
        this.queueSize = queueSize;
        ItemArray = new int[queueSize];
    }
    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return (front==rear);
    }
    // 큐가 가득차 있는지 확인
    public boolean isFull() {
        return ((rear+1)%this.queueSize==front);
    }
    // 큐의 삽입 연산
    public void enQueue(int item) {
        if(isFull()){
            System.out.println("큐가 포화 상태");
        }else{
            rear = (rear+1)%(queueSize);
            ItemArray[rear] = item;
        }
    }
    // 큐의 삭제 후 반환 연산
    public int deQueue() {
        if(isEmpty()){
            System.out.println("큐가 공백 상태");
            return 0;
        }else{
            front = (front+1)%queueSize;
            return ItemArray[front];
        }
    }

    // 큐의 현재 front값 출력
    public int peek() {
        if(isEmpty()){
            System.out.println("큐가 비어있음");
            return 0;
        }else{
            return ItemArray[(front+1)%queueSize];
        }
    }
    // 전체 큐값 출력
    public void print(){
        if(isEmpty()){
            System.out.println("큐가 비어있음");
        }else{
            int f = front;

            while(f!=rear){
                f = (f+1)%queueSize;
                System.out.print(ItemArray[f] + " ");
            }
            System.out.println();
        }
    }
}
public class CircularQueueTest {
    public static void main(String[] args){
        CircularQueue q = new CircularQueue(10); // 원형 큐 객체 생성
        for(int i=1; i<=5; i++) // 큐에 삽입
            q.enQueue(i); System.out.print("원형큐 출력 : ");
        for(int i=1; i<=5; i++) // 큐에서 삭제
            System.out.print(q.deQueue() + " ");

        q.print();
    }
}