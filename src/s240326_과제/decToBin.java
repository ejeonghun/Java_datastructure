package s240326_과제;

import java.util.Scanner;
import java.util.Stack;

public class decToBin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("입력: (정수) ");
        int dec = input.nextInt();
        toBin(dec); // toBin 함수 호출하여 입력된 정수를 이진수로 변환하여 출력
    }

    // 입력된 정수를 이진수로 변환하는 함수
    static void toBin(int dec) {
        int tmp = dec; // 변환할 정수를 임시로 저장하는 변수
        Stack<Integer> res = new Stack<>(); // 이진수의 각 자리를 저장하는 스택

        // 정수를 이진수로 변환하는 과정
        while (true) {
            // 변환할 정수가 1 이하이면 스택에 추가하고 반복문 종료
            if (tmp <= 1) {
                res.push(tmp);
                break;
            }
            // 정수를 2로 나눈 나머지를 스택에 추가하고 다음 자릿수로 넘어감
            res.push(tmp % 2);
            tmp = tmp / 2;
        }

        int size = res.size(); // 스택의 크기를 저장하는 변수
        // 스택에 저장된 이진수를 출력
        for (int i = 0; i < size; i++) {
            System.out.print(res.pop());
        }
    }
}
