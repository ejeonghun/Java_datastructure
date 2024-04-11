package s240319;

import java.util.LinkedList;

public class PolynomialTest3 {
    static class Node {
        int coef; // 다항식 항의 계수
        int expo; // 다항식 항의 지수
        public Node(int coef, int expo) {
            this.coef = coef;
            this.expo = expo;
        }
        public String toString() { // 다항식 객체 문자열 변환
            return String.format("%dx^%d", coef, expo);
        }
    }

    public static void main(String[] args) {
    // 다항식 A 만들기
        LinkedList<Node> polyA = new LinkedList<>();
        polyA.add(new Node(4, 3));
        polyA.add(new Node(3, 2));
        polyA.add(new Node(5, 1));
        System.out.println("다항식 A : " + polyA);
    // 다항식 B 만들기
        LinkedList<Node> polyB = new LinkedList<>();
        polyB.add(new Node(3, 4));
        polyB.add(new Node(1, 3));
        polyB.add(new Node(2, 1));
        polyB.add(new Node(1, 0));
        System.out.println("다항식 B : " + polyB);
        LinkedList<Node> polyC = AddPolynomial(polyA, polyB);
        System.out.println("다항식 A+B : " + polyC);
        LinkedList<Node> polymul = MulPolynomaial(polyA, polyB);
        System.out.println("다항식 A*B : " + polymul);
    }
    static LinkedList<Node> AddPolynomial(LinkedList<Node> A, LinkedList<Node> B) {
        int i = 0, j = 0;
        LinkedList<Node> C = new LinkedList<>();
        // A나 B 둘 중 하나가 모든 항에 대해 덧셈이 끝나는 경우 while 종료
        while (i < A.size() && j < B.size()) {
        // B의 지수가 A의 지수보다 큰 경우
            if (A.get(i).expo > B.get(j).expo) {
                C.add(new Node(A.get(i).coef, A.get(i).expo));
                ++i;
            }
            // A의 지수가 B의 지수보다 큰 경우
            else if (A.get(i).expo < B.get(j).expo) {
                C.add(new Node(B.get(j).coef, B.get(j).expo));
                ++j;
            }
            // A의 지수와 B의 지수가 같은 경우
            else {
                C.add(new Node(A.get(i).coef + B.get(j).coef, A.get(i).expo));
                ++i;
                ++j;
            }
        }
        // A에 항이 남아 있는 경우 C에 추가
        while (i < A.size()) {
            C.add(new Node(A.get(i).coef, A.get(i).expo));
            ++i;
        }
        // B에 항이 남아 잇는 경우 C에 추가
        while (j < B.size()) {
            C.add(new Node(B.get(j).coef, B.get(j).expo));
            ++j;
        }
        return C;
    }

    static LinkedList<Node> MulPolynomaial(LinkedList<Node> A, LinkedList<Node> B) {
        LinkedList<Node> res = new LinkedList<>();

        for(int i=0; i<A.size(); i++) {
            LinkedList<Node> tmp = new LinkedList<>();
            for(int j = 0; j < B.size(); j++) {
                tmp.add(new Node(A.get(i).coef * B.get(j).coef, A.get(i).expo + B.get(j).expo)); // 수정된 부분
            }
            res = AddPolynomial(res, tmp);
        }
        return res;
    }
}