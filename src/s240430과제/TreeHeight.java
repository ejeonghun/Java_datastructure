package s240430과제;
/*
*  아래 이진 트리의 높이와 노드의 개수를 출력하는 프로그램을 작성하시오. (후위순회 응용)
*
*                           A
*                     /             \
*               B                   C
*           /       \             /     \
*          D         E           F       G
*       /     \                        /   \
*     H        I                      J     K
*
*
* 조건 : 아래 형식의 메소드 작성
1) int height(Node root)
2) int cntNode(Node root)
* */
class Node { // 노드 클래스 정의
    private String value; // 영문자를 저장하기위해 String 타입으로 선언
    private Node left; // 왼쪽 자식 노드를 참조하는 포인터(참조형 변수)
    private Node right; // 오른쪽 자식 노드를 참조하는 포인터(참조형 변수)
    public Node(Node l, String v, Node r) { // 인자 3개인 생성자
        left = l;
        value = v;
        right = r;
    }
    public void setValue(String v) { // 설정자
        value = v;
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
    public void postOrder(Node root) { // 후위순회 메소드
        if (root ==null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() +" ");
    }
    public int height(Node root) {
        if(root == null)
            return 0;
        int l = height(root.getLeft());
        int r = height(root.getRight());
        return Math.max(l, r) + 1;
    }
    public int cntNode(Node root) {
        if(root == null)
            return 0;
        int leftCnt = cntNode(root.getLeft());
        int rightCnt = cntNode(root.getRight());
        return leftCnt + rightCnt + 1; // 현재 노드(root)를 포함하여 합산
    }
}
public class TreeHeight {
    public static void main(String[] args) {
        // 높이 4, 노드 11 객체 노드 객체
        Node h =new Node(null, "H", null);
        Node i =new Node(null, "I", null);
        Node j =new Node(null, "J", null);
        Node k =new Node(null, "K", null);
        Node d =new Node(h, "D", i);
        Node e =new Node(null, "E", null);
        Node f =new Node(null, "F", null);
        Node g =new Node(j, "G", k);
        Node b =new Node(d, "B", e);
        Node c =new Node(f, "C", g);
        Node a =new Node(b, "A", c);
        BinaryTree tree =new BinaryTree(a); // 이진트리 객체 생성
        System.out.println("높이 : "+ tree.height(a));
        System.out.println("노드 수 : "+ tree.cntNode(a));
    }
}
