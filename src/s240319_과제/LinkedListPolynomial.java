package s240319_과제;

import java.util.LinkedList;

class PolyNode {
    public int coef;
    public int expo;

    public PolyNode(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    @Override
    public String toString() {
        return String.format("%dx^%d", coef, expo);
    }
}

class Polynomial {
    static LinkedList<PolyNode> AddPoly(LinkedList<PolyNode> A,LinkedList<PolyNode> B) {
        int i = 0; int j = 0;
        LinkedList<PolyNode> res = new LinkedList<>();

        while(i < A.size() && j < B.size()) {
            // B의 지수가 A의 지수보다 큰 경우 -> 지수는 expo
            if (A.get(i).expo > B.get(j).expo) {
                res.add(new PolyNode(A.get(i).coef, A.get(j).expo));
                i++;
            }
            // A의 지수가 B의 지수보다 큰 경우
            else if(A.get(i).expo < B.get(j).expo) {
                res.add(new PolyNode(B.get(j).coef, B.get(j).expo));
                ++j;
            }
            // A과 B의 지수가 같을 때
            else {
                res.add(new PolyNode(A.get(i).coef + B.get(j).coef, A.get(i).expo));
                ++i; ++j;
            }
        }
        // A에 항이 남아 있는 경우 res에 추가
        while(i < A.size()) {
            res.add(new PolyNode(A.get(i).coef, A.get(i).expo));
            i++;
        }
        // B에 항이 남아 있는 경우 res에 추가
        while(j < B.size()) {
            res.add(new PolyNode(B.get(j).coef, B.get(j).expo));
            j++;
        }
        return res;
    }

    static LinkedList<PolyNode> MulPoly(LinkedList<PolyNode> A, LinkedList<PolyNode> B) {
        LinkedList<PolyNode> res = new LinkedList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                int coef = A.get(i).coef * B.get(j).coef;
                int expo = A.get(i).expo + B.get(j).expo;

                // 이미 존재하는 지수인 경우 해당 항목의 계수를 더함
                boolean found = false;
                for (PolyNode node : res) {
                    if (node.expo == expo) {
                        node.coef += coef;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    res.add(new PolyNode(coef, expo));
                }
            }
        }
        return res;
    }
}

public class LinkedListPolynomial {
    public static void main(String[] args) {
        LinkedList<PolyNode> polyA = new LinkedList<>();
        polyA.add(new PolyNode(5,4));
        polyA.add(new PolyNode(6,3));
        polyA.add(new PolyNode(7,0));
        System.out.println("다항식 A : " + polyA);

        LinkedList<PolyNode> polyB = new LinkedList<>();
        polyB.add(new PolyNode(2,3));
        polyB.add(new PolyNode(-7,2));
        polyB.add(new PolyNode(3,1));
        System.out.println("다항식 B : " + polyB);

        LinkedList<PolyNode> addPoly = Polynomial.AddPoly(polyA, polyB);
        System.out.println(addPoly);

        LinkedList<PolyNode> mulPoly = Polynomial.MulPoly(polyA, polyB);
        System.out.println(mulPoly);
    }
}
