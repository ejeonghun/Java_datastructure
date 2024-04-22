package s240326_과제;

import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        String postfix = "2 5 + 3 * 4 -"; // 후위식
        System.out.println("후위식: " + postfix);
        CalPostfix(postfix); // 후위식을 계산하는 메서드 호출
    }

    public static void CalPostfix(String postfix) {
        char oneCh = ' '; // 한 글자씩 저장할 변수
        int postSize = postfix.length(); // 후위식 길이
        int num1 = 0;
        int num2 = 0; // 왼쪽 수, 오른쪽 수
        Stack<Integer> numStack = new Stack<>(); // 피연산자를 저장하는 스택

        for (int i = 0; i < postSize; i++) {
            oneCh = postfix.charAt(i); // 후위식의 각 문자를 가져옴
            if (oneCh == '+' || oneCh == '-' || oneCh == '*' || oneCh == '/') {
                num2 = numStack.pop(); // 스택에서 피연산자를 꺼내어 오른쪽 수로 지정
                num1 = numStack.pop(); // 스택에서 피연산자를 꺼내어 왼쪽 수로 지정
                // 연산자에 따라 계산하여 결과를 스택에 다시 저장
                switch (oneCh) {
                    case '+':
                        numStack.push(num1 + num2);
                        break;
                    case '-':
                        numStack.push(num1 - num2);
                        break;
                    case '*':
                        numStack.push(num1 * num2);
                        break;
                    case '/':
                        numStack.push(num1 / num2);
                        break;
                }
            } else if (oneCh == ' ')
                continue; // 공백이면 건너뜀
            else // 피연산자인 경우 스택에 push
                numStack.push(oneCh - '0');
        }

        System.out.println("결과: " + numStack.pop()); // 계산 결과 출력
    }
}
