package s240326;

class ArrayStack {
    private Integer data[];
    private int top;
    private int maxSize;
    public ArrayStack(int initsize) { // 생성자
        data = new Integer[initsize];
        top = 0;
        maxSize = initsize;
    }
    public boolean empty() { // 공백 상태 체크
        return top == 0;
    }
    public boolean full() { // 포화상태 체크
        return top == maxSize;
    }
    public void push(Integer elem) { // push 연산
        if (top == maxSize){
            System.out.println("overflow"); // 스택이 꽉차면 overflow
            return;
        }
        data[top++] = elem;
    }
    public Integer pop() { // pop 연산
        if (top > 0)
            return data[--top];
        else
            return null; // 스택이 비어있으면 null 반환
    }
}
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5); // 크기가 5인 배열 스택 생성
        for (int i = 1; i <= 5; i++)
            as.push(i); // 스택에 push
        System.out.print("Pop : ");
        for (int i = 1; i <= 5; i++)
            System.out.print(as.pop()+" "); // 스택에서 pop(역순출력)
    }
}