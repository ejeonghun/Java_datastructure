package s240430과제;
/*
 * 아래 디렉토리의 용량을 계산하여 출력하는 프로그램을 작성하시오.(후위순회 응용)
 *
 *               나의 문서
 *             /           \
 *   음악(50kb)            그림(100kb)
 *                       /            \
 *                 정지영상(200kb)   동영상(500kb)
 * */
class Directory { // 노드 클래스 정의
    private int value; // 영문자를 저장하기위해 String 타입으로 선언
    private Directory left; // 왼쪽 자식 노드를 참조하는 포인터(참조형 변수)
    private Directory right; // 오른쪽 자식 노드를 참조하는 포인터(참조형 변수)
    public Directory(Directory l, int v, Directory r) { // 인자 3개인 생성자
        left = l;
        value = v;
        right = r;
    }
    public void setValue(int v) { // 설정자
        value = v;
    }
    public void setLeft(Directory l) {
        left = l;
    }
    public void setRight(Directory r) {
        right = r;
    }
    public int getValue() { // 접근자
        return value;
    }
    public Directory getLeft() {
        return left;
    }
    public Directory getRight() {
        return right;
    }
}
class BinaryTree2 { // 이진트리 클래스
    private Directory root; // 루트 노드 참조 변수
    public BinaryTree2(Directory r) { // 생성자
        root = r;
    }
    public void postOrder(Directory root) { // 후위순회 메소드
        if (root == null)
            return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() +" ");
    }
    public int SumDirectory(Directory root) {
        int sum = 0;
        if (root == null)
            return 0;
        sum += SumDirectory(root.getLeft());
        sum += SumDirectory(root.getRight());
        return root.getValue() + sum;
    }
}
public class Directory_test {
    public static void main(String[] args) {
        Directory StopVideo = new Directory(null, 200, null);
        Directory Video = new Directory(null, 500, null);
        Directory Music = new Directory(null, 50, null);
        Directory Picture = new Directory(StopVideo, 100 ,Video);
        Directory myDocs = new Directory(Music, 0, Picture);
        BinaryTree2 Tree = new BinaryTree2(myDocs);
        Tree.postOrder(myDocs);
        System.out.println();
        System.out.printf("총 용량 : %dkb", Tree.SumDirectory(myDocs));
    }
}