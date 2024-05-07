package s240430;

import java.util.LinkedList;
import java.util.Queue;

class Node3 { // 노드 클래스 정의
    private String value; // 영문자를 저장하기위해 String 타입으로 선언
    private Node3 left; // 왼쪽 자식 노드를 참조하는 포인터(참조형 변수)
    private Node3 right; // 오른쪽 자식 노드를 참조하는 포인터(참조형 변수)

    public Node3(Node3 l, String v, Node3 r) { // 인자 3개인 생성자
        left = l;
        value = v;
        right = r;
    }

    public void setLeft(Node3 l) {
        left = l;
    }

    public void setRight(Node3 r) {
        right = r;
    }

    public String getValue() { // 접근자
        return value;
    }

    public Node3 getLeft() {
        return left;
    }

    public Node3 getRight() {
        return right;
    }
}

class BinaryTree3 { // 이진트리 클래스
    private Node3 root; // 루트 노드 참조 변수

    public BinaryTree3(Node3 r) { // 생성자
        root = r;
    }

    public void preOrder(Node3 root) { // 전위순회 메소드
        if (root == null)
            return;
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node3 root) { // 중위순회 메소드
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(Node3 root) { // 후위순회 메소드
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    // level order(레벨 오더) 구현
    public void levelOrder(Node3 root) {
        Queue<Node3> q = new LinkedList<>();
        q.add(root); // 루트 노드 큐에 삽입
        while(!q.isEmpty()) { // q가 비어있으면 끝남
            Node3 tempNode = q.poll(); // q의 노드를 꺼냄
            System.out.print(tempNode.getValue() + " "); // 해당 노드의 값 출력

            // 왼쪽 자식 추가
            if (tempNode.getLeft() != null) { // 왼쪽 자식이 있으면 큐에 추가
                q.add(tempNode.getLeft());
            }
            // 오른쪽 자식 추가
            if (tempNode.getRight() != null) { // 오른쪽 자식이 있으면 큐에 추가
                q.add(tempNode.getRight());
            }
            // 만약 더이상 자식이 없으면
        }
    }

}

public class 레벨오더함수추가 {
    public static void main(String[] args) {
        // 노드 객체 생성(Bottom-Up 방식으로 단말노드부터 생성)
        Node3 h = new Node3(null, "H", null);
        Node3 i = new Node3(null, "I", null);
        Node3 j = new Node3(null, "J", null);
        Node3 k = new Node3(null, "K", null);
        Node3 d = new Node3(h, "D", i);
        Node3 e = new Node3(null, "E", null);
        Node3 f = new Node3(null, "F", null);
        Node3 g = new Node3(j, "G", k);
        Node3 b = new Node3(d, "B", e);
        Node3 c = new Node3(f, "C", g);
        Node3 a = new Node3(b, "A", c); // 마지막에 루트노드 생성
        BinaryTree3 tree = new BinaryTree3(a); // 이진트리 객체 생성
        System.out.print("PreOrder : ");
        tree.preOrder(a);
        System.out.println();
        System.out.print("InOrder : ");
        tree.inOrder(a);
        System.out.println();
        System.out.print("PostOrder : ");
        tree.postOrder(a);
        System.out.println();
        System.out.print("LevelOrder : ");
        tree.levelOrder(a);
    }
}