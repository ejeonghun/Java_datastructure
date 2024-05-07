package s240430;

import java.util.LinkedList;
import java.util.Queue;

class Node { // 노드 클래스 정의
    private String value; // 영문자를 저장하기위해 String 타입으로 선언
    private Node left; // 왼쪽 자식 노드를 참조하는 포인터(참조형 변수)
    private Node right; // 오른쪽 자식 노드를 참조하는 포인터(참조형 변수)

    public Node(Node l, String v, Node r) { // 인자 3개인 생성자
        left = l;
        value = v;
        right = r;
    }

    public void setLeft(Node l) {
        left = l;
    }

    public void setRight(Node r) {
        right = r;
    }

    public String getValue() { // 접근자
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}

class BinaryTree { // 이진트리 클래스
    private Node root; // 루트 노드 참조 변수

    public BinaryTree(Node r) { // 생성자
        root = r;
    }

    public void preOrder(Node root) { // 전위순회 메소드
        if (root == null)
            return;
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(Node root) { // 중위순회 메소드
        if (root == null)
            return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public void postOrder(Node root) { // 후위순회 메소드
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    // level order(레벨 오더) 구현
    public void levelOrder(Node root) {
        Queue<String> table = new LinkedList<>();

    }
}

public class BinaryTreeTest {
    public static void main(String[] args) {
        // 노드 객체 생성(Bottom-Up 방식으로 단말노드부터 생성)
        Node h = new Node(null, "H", null);
        Node i = new Node(null, "I", null);
        Node j = new Node(null, "J", null);
        Node k = new Node(null, "K", null);
        Node d = new Node(h, "D", i);
        Node e = new Node(null, "E", null);
        Node f = new Node(null, "F", null);
        Node g = new Node(j, "G", k);
        Node b = new Node(d, "B", e);
        Node c = new Node(f, "C", g);
        Node a = new Node(b, "A", c); // 마지막에 루트노드 생성
        BinaryTree tree = new BinaryTree(a); // 이진트리 객체 생성
        System.out.print("PreOrder : ");
        tree.preOrder(a);
        System.out.println();
        System.out.print("InOrder : ");
        tree.inOrder(a);
        System.out.println();
        System.out.print("PostOrder : ");
        tree.postOrder(a);
    }
}