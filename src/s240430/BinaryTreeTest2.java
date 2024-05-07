package s240430;

/*
아래 이진트리의 전위순회, 중위순회, 후위순회, 레벨순회 결과를 출력하
는 프로그램을 작성하시오.

            A
         /     \
       B        C
     /   \        \
    D     E         G
     \
      I
* */

import java.util.LinkedList;
import java.util.Queue;

class Node2 { // 노드 클래스 정의
    private String value; // 영문자를 저장하기위해 String 타입으로 선언
    private Node2 left; // 왼쪽 자식 노드를 참조하는 포인터(참조형 변수)
    private Node2 right; // 오른쪽 자식 노드를 참조하는 포인터(참조형 변수)

    public Node2(Node2 l, String v, Node2 r) { // 인자 3개인 생성자
        left = l;
        value = v;
        right = r;
    }

    public void setLeft(Node2 l) {
        left = l;
    }

    public void setRight(Node2 r) {
        right = r;
    }

    public String getValue() { // 접근자
        return value;
    }

    public Node2 getLeft() {
        return left;
    }

    public Node2 getRight() {
        return right;
    }
}

class BinaryTree2 { // 이진트리 클래스
    private Node2 root; // 루트 노드 참조 변수

    public BinaryTree2(Node2 r) { // 생성자
        root = r;
    }

    public void preOrder(Node2 root) { // 전위순회 메소드
        if (root == null)
            return;
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node2 root) { // 중위순회 메소드
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(Node2 root) { // 후위순회 메소드
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    // level order(레벨 오더) 구현
    public void levelOrder(Node2 root) {
        Queue<Node2> q = new LinkedList<>();
        q.add(root); // 루트 노드 큐에 삽입
        while(!q.isEmpty()) { // q가 비어있으면 끝남
            Node2 tempNode = q.poll(); // q의 노드를 꺼냄
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

public class BinaryTreeTest2 {
    public static void main(String[] args) {
        // 노드 객체 생성(Bottom-Up 방식으로 단말노드부터 생성)
        Node2 i = new Node2(null, "i", null);
        Node2 d = new Node2(null, "d",  i);
        Node2 e = new Node2(null, "e", null);
        Node2 g = new Node2(null, "g", null);
        Node2 b = new Node2(d, "b", e);
        Node2 c = new Node2(null, "c", g);
        Node2 a = new Node2(b, "A", c); // 마지막에 루트노드 생성
        BinaryTree2 tree = new BinaryTree2(a); // 이진트리 객체 생성
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