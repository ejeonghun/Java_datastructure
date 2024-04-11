package s240312;

import java.util.ArrayList;
public class PolynomialTest1 {
    public static void main(String[] args) {
// 다항식 A 만들기
        ArrayList<Integer> polyA = new ArrayList<>();
        polyA.add(0);
        polyA.add(5);
        polyA.add(3);
        polyA.add(4);
        System.out.println("다항식 A : " + toPoly(polyA));
// 다항식 B 만들기
        ArrayList<Integer> polyB = new ArrayList<>();
        polyB.add(1);
        polyB.add(2);
        polyB.add(0);
        polyB.add(1);
        polyB.add(3);
        System.out.println("다항식 B : " + toPoly(polyB));
        ArrayList<Integer> polyC = AddPolynomial(polyA, polyB); // 다항식 합
        System.out.println("다항식 A+B : " + toPoly(polyC));
    }
    static ArrayList<Integer> AddPolynomial(ArrayList<Integer> A, ArrayList<Integer> B) {
        int i ;
        int min = (A.size()<B.size())?A.size():B.size(); // 더 작은 차수 확인
        ArrayList<Integer> C = new ArrayList<>(); // 다항식 C 생성
        for(i=0; i<min; i++) { // 동일 차수끼리 계수 합
            C.add(A.get(i) + B.get(i));
        }
// 남은 항을 다항식 C에 복사
        if(A.size()<B.size())
            for(i=min; i<B.size(); i++)
                C.add(B.get(i));
        else
            for(i=min; i<A.size(); i++)
                C.add(A.get(i));
        return C;
    }

    static String toPoly(ArrayList<Integer> list) { // ArrayList를 다항식 형태의 문자열로 변환
        int i;
        StringBuffer s= new StringBuffer("[");
        for(i=list.size()-1; i>=0; i--){
            s.append(String.format("%dx^%d", list.get(i), i));
            if(i>0)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
}
