package s240507;

import java.util.*;
public class BinarySearchTree1 {
    class Node { // 이진탐색트리를 구성하는 노드 객체의 타입
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root; // 루트 노드 저장 변수
    BinarySearchTree1() {
        root = null;
    }
    void insert(int key) { // 이진탐색트리에 데이터 추가
        root = insertRec(root, key);
        // 내부에서 재귀호출로 다시 불러서 사용
        // 재귀호출은 인자값이 무조건 하나 이상 더 많을 수 밖에 없음 만약 없으면 무한재귀호출에 빠질수도있음
    }

    Node insertRec(Node root, int key) { // root를 루트로 하는 서브트리에 key 값 추가
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) // 루트 값보다 작은면, 왼쪽 서브트리로
            root.left = insertRec(root.left, key);
        else if (key > root.key) // 루트 값보다 작은면, 왼쪽 서브트리로
            root.right = insertRec(root.right, key);
        return root;
    }
    void inorder() { // 중위 순회
        inorderRec(root);
    }
    void inorderRec(Node root) { // root를 루트로 가지는 서브트리 중위 순회
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    /*
    * 재귀호출로 동작을 하고, 현재 노드가 null이거나, 현재 노드의 키 값이 찾고자 하는 키 값(key)과 같은지 확인
    * 만약 두 조건 중 하나라도 만족하면 현재 노드를 반환함.
    * 찾고자 하는 키 값이 현재 노드의 키 값보다 작다면, 현재 노드의 왼쪽 자식 노드를 루트로 하는 서브 트리에서 키 값을 찾음
    *
    * */
    public Node search(Node root, int key) { // root 서브트리에 key 값 검색
        if (root==null || root.key==key)
            return root;

        if (root.key > key)
            return search(root.left, key);

        return search(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree1 tree = new BinarySearchTree1();
        // 이진탐색트리에 데이터 추가
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder(); // 이진탐색트리 중위 순회 : 오름차순 정렬
        System.out.println(tree.search(tree.root, 90)); // 만약 찾는 값이 없으면 Node의 값이 없으니까 null임
        if (tree.search(tree.root, 30) != null) // 이진탐색트리에서 30 검색
            System.out.printf("%d : 검색성공\n", 30);
        else
            System.out.printf("%d : 검색실패\n", 30);
    }
}
