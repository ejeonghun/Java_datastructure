package s240312;

import java.util.ArrayList;

public class PolynomialTest3_곱하기 {

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
        ArrayList<Node> polyA = new ArrayList<>();
        polyA.add(new Node(5, 4));
        polyA.add(new Node(6, 3));
        polyA.add(new Node(7, 0));
        System.out.println("다항식 A : " + polyA);

        ArrayList<Node> polyB = new ArrayList<>();
        polyB.add(new Node(2, 3));
        polyB.add(new Node(7, 2));
        polyB.add(new Node(3,1));
        System.out.println("다항식 B : " + polyB);

        ArrayList<Node> polyD = AddPolynomial(polyA, polyB);
        System.out.println("다항식 A+B : " + polyD );

        ArrayList<Node> polyC = MulPolynomial(polyA, polyB);
        System.out.println("다항식 A*B : " + polyC);
    }
    static ArrayList<Node> AddPolynomial(ArrayList<Node> A, ArrayList<Node> B) {
        int i = 0, j = 0;
        ArrayList<Node> result = new ArrayList<>();

        while(i < A.size() && j < B.size()) {
            if(A.get(i).expo == B.get(j).expo) {
                result.add(new Node(A.get(i).coef + B.get(j).coef, A.get(i).expo));
                i++; j++;
            } else if(A.get(i).expo > B.get(j).expo) {
                result.add(new Node(A.get(i).coef, A.get(i).expo));
                i++;
            } else {
                result.add(new Node(B.get(j).coef, B.get(j).expo));
                j++;
            }
        }

        while(i < A.size()) {
            result.add(new Node(A.get(i).coef, A.get(i).expo));
            i++;
        }

        while(j < B.size()) {
            result.add(new Node(B.get(j).coef, B.get(j).expo));
            j++;
        }

        return result;
    }


    static ArrayList<Node> MulPolynomial(ArrayList<Node> A, ArrayList<Node> B) {
        ArrayList<Node> result = new ArrayList<>();

        for (Node nodeA : A) {
            for (Node nodeB : B) {
                int coef = nodeA.coef * nodeB.coef;
                int expo = nodeA.expo + nodeB.expo;
                result.add(new Node(coef, expo));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            Node nodeI = result.get(i);
            for (int j = i + 1; j < result.size(); j++) {
                Node nodeJ = result.get(j);
                if (nodeI.expo == nodeJ.expo) {
                    nodeI.coef += nodeJ.coef;
                    result.remove(j);
                    j--;
                }
            }
        }

        return result;
    }
}
