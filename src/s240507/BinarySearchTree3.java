package s240507;

import java.util.*;
/*
* 노드 삭제 시 왼쪽 서브트리의 가장 큰 값을 선택하도록
* */
class BinarySearchTree3 {
    class Node { // 이진탐색트리의 노드 객체 타입
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree3() {
        root = null;
    }
    void deleteKey(int key) { // 이진탐색트리에서 key 값 삭제
        root = deleteRec(root, key);
    }
    Node deleteRec(Node root, int key) { // root 서브트리에서 key 값 삭제
        if (root == null) return root;
        if (key > root.key) // 루트보다 크면 오른쪽 서브로
            root.right = deleteRec(root.right, key);
        else if (key < root.key) // 루트보다 작으면 왼쪽 서브로
            root.left = deleteRec(root.left, key);
        else {
            if (root.left == null) // 왼쪽 자식노드가 없으면
                return root.right;
            else if (root.right == null) // 오른쪽 자식노드가 없으면
                return root.left;
            // 왼쪽 서브트리에서 가장 큰 값을 찾아서 삭제할 노드의 키값으로 설정
            System.out.println("오른쪽 서브트리에서 가장 큰 값을 찾아서 삭제할 노드의 키 값으로 설정 "+ maxValue(root.left));
            root.key = maxValue(root.left);
            // 왼쪽 서브트리에서 가장 큰 값을 삭제
            root.left = deleteRec(root.left, root.key);
        }
        return root;
    }

    int maxValue(Node root) { // root 서브트리에서 최대값 반환
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }


    void insert(int key) { // 이진탐색트리에 key 값 삽입
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) { // root 서브트리에 key 값 삽입
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
    void inorder() { // 이진탐색트리 중위순회
        inorderRec(root);
    }
    void inorderRec(Node root) { // root 서브트리 중위순회
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree3 tree = new BinarySearchTree3();
        // 이진탐색트리에 데이터 추가
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("중위순회 : ");
        tree.inorder(); // 중위순회 : 오름차순 정렬
        System.out.println("\n20 삭제");
        tree.deleteKey(20); // 데이터 20 삭제
        System.out.println("중위순회 : ");
        tree.inorder(); // 중위순회 : 오름차순 정렬
        System.out.println("\n30 삭제");
        tree.deleteKey(30); // 데이터 20 삭제
        System.out.println("중위순회 : ");
        tree.inorder(); // 중위순회 : 오름차순 정렬
        System.out.println("\n50 삭제");
        tree.deleteKey(50); // 데이터 20 삭제
        System.out.println("중위순회 : ");
        tree.inorder(); // 중위순회 : 오름차순 정렬
    }
}
