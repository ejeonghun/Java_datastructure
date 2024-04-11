package s240402;

class LinkedQueue {

    private class Node{ // 연결큐를 구성하는 노드 객체의 타입

        // 노드는 data와 다음 노드를 가진다.
        private int data;
        private Node nextNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;
        }
    }

    // 큐는 front노드와 rear노드를 가진다.
    private Node front;
    private Node rear;

    public LinkedQueue(){
        this.front = null;
        this.rear = null;
    }

// 큐가 비어있는지 확인
public boolean empty(){
    return (front==null);
}

    // item을 큐의 rear에 넣는다.
    public void enQueue(int item){

        Node node = new Node(item);
        node.nextNode = null;

        if(empty()){
            rear = node;
            front = node;
        }else{
            rear.nextNode = node;
            rear = node;
        }
    }

    // front의 데이터를 반환한다.
    public int peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return front.data;
    }

    // front를 큐에서 제거한다.
    public int deQueue(){

        int item = peek();
        front = front.nextNode;

        if(front == null){
            rear = null;
        }
        return item;
    }
}
public class LinkedQueueTest {
    public static void main(String[] args){
        LinkedQueue q = new LinkedQueue(); // 연결큐 객체 생성
        for(int i=1; i<=5; i++) // 큐에 삽입
            q.enQueue(i);
        System.out.print("연결큐 출력 : ");
        for(int i=1; i<=5; i++) // 큐에서 삭제
            System.out.print(q.deQueue() + " ");
    }
}