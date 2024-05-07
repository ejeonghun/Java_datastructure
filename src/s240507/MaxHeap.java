package s240507;

import java.util.*;
public class MaxHeap {
    private int[] Heap; // 이진트리(힙)를 표현하는 배열
    private int size;
    private int maxsize;
    private static final int FRONT = 1;
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
    private int parent(int pos){ // 부모노드 반환
        return pos / 2;
    }
    private int leftChild(int pos) { // 왼쪽 자식노드 반환
        return (2 * pos);
    }
    private int rightChild(int pos) { // 오른쪽 자식노드 반환
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos) { // 단말노드 체크
        if (pos > (size / 2) && pos <= size)
            return true;
        return false;
    }
    private void swap(int fpos, int spos){ // 두 노드간에 위치 교환
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void maxHeapify(int pos) { // MaxHeap 만족하도록 재구성
        if (!isLeaf(pos))
            if (Heap[pos] < Heap[leftChild(pos)] ||
                    Heap[pos] < Heap[rightChild(pos)])
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else{
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
    }
    public void insert(int element) { // 힙에 데이터 추가 연산 수행
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void print(){ // 힙에 저장된 데이터 출력
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT_CHILD : " +
                    Heap[2 * i] + " RIGHT_CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
    public int remove() { // 힙에서 데이터 삭제 연산 수행
        int popped = Heap[FRONT]; // FRONT는 1 == root 위치
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }
    public static void main(String[] arg) {
        System.out.println("Max Heap : ");
        MaxHeap maxHeap = new MaxHeap(15); // 크기가 15인 힙 객체 생성
        // 힙에 데이터 추가
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("최대값 : " + maxHeap.remove());
        // 배열의 0번째 인덱스는 비어있기 때문에 remove를 하면 1번째 값이 나옴
        System.out.println("삭제 작업");
        System.out.println("가장 큰 값(84)이 삭제되고 그 다음 큰 값인 22가 root가 됨");
        maxHeap.print();
        System.out.println("최대값 : " + maxHeap.remove());
    }
    /*         최대힙 결과
    *              84
    *          22      19
    *       17   10   5   6
    *     3    9
    *  */
}
