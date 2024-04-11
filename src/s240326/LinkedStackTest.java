package s240326;

class LinkedStack {

    private Node top;

    // 노드 class 단순연결 리스트와 같다.
    private class Node{

        private Integer data;
        private Node nextNode;

        Node(Integer data){
            this.data = data;
            this.nextNode = null;
        }
    }

    // 생성자, stack이 비어있으므로 top은 null이다.
    public LinkedStack(){
        this.top = null;
    }

    // 스택이 비어있는지 확인
    public boolean empty(){
        return (top == null);
    }

    // item을 스택의 top에 넣는다.
    public void push(Integer item){Node newNode = new Node(item);
        newNode.nextNode = top;
        top = newNode;

    }

    // top 노드의 데이터를 반환한다.
    public Integer peek(){
        if(empty()) {
            System.out.println("공백상태");
            return null;
        }
        return top.data;
    }

    // top 노드를 스택에서 제거한다.
    public Integer pop(){

        Integer item = peek();
        top = top.nextNode;
        return item;
    }
}
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack s = new LinkedStack(); // 연결 스택 생성
        for (int i = 1; i <= 5; i++)
            s.push(i);
        System.out.print("Pop : ");
        for (int i = 1; i <= 5; i++)
            System.out.print(s.pop() + " ");
    }
}