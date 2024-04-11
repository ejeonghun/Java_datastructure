package s240319_과제;

import java.math.BigInteger;
import java.util.LinkedList;

public class TwoSquared {
    public static void main(String[] args) {
        // LinkedList를 BigInteger 타입으로 생성합니다.
        LinkedList<BigInteger> list = new LinkedList<>();

        // 리스트에 2를 추가합니다.
        list.add(BigInteger.valueOf(2));

        // 2의 제곱을 100번 계산하여 리스트에 추가합니다.
        for (int i = 1; i < 100; i++) {
            // 리스트의 마지막 요소를 가져옵니다.
            BigInteger lastElement = list.getLast();

            // 마지막 요소에 2를 곱하여 다음 요소를 계산합니다.
            BigInteger nextElement = lastElement.multiply(BigInteger.valueOf(2));

            // 계산한 결과를 리스트에 추가합니다.
            list.add(nextElement);
        }

        // "2의 100제곱은 " 뒤에 계산 결과를 출력합니다.
        System.out.println("2의 100제곱은 " + list.getLast());
    }
}
