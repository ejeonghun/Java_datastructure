package s240326_과제;

import java.util.Stack;

public class infix2postfix {
    public static void main(String[] args) {
        String infix = "A + B * C - D / E"; // 중위 표기법으로 된 수식
//        String infix = "(2 + 5) * 3 - 4"; // 테스트용 다른 중위 표기법 수식
        System.out.println("입력: " + infix); // 입력된 중위 표기법 수식 출력
        System.out.println("결과: " + In2Post(infix)); // 중위 표기법 수식을 후위 표기법으로 변환하여 출력
    }

    // 중위 표기법을 후위 표기법으로 변환하는 메서드
    static String In2Post(String infix) {
        Stack<String> st = new Stack<>(); // 연산자를 임시로 저장할 스택
        String postfixString = " "; // 후위 표기법으로 변환된 문자열을 저장할 변수

        // 중위 표기법 수식을 문자 단위로 순회
        for (int index = 0; index < infix.length(); index++) {
            char chValue = infix.charAt(index); // 수식의 현재 문자를 가져옴

            // 공백이면 무시하고 다음 문자로 이동
            if (chValue == ' ')
                continue;

            // 여는 괄호는 스택에 직접 푸시
            if (chValue == '(')
                st.push("(");

                // 닫는 괄호를 만나면 스택에서 여는 괄호를 만날 때까지 연산자를 pop하여 후위 표기법에 추가
            else if (chValue == ')') {
                String oper = st.peek();
                while (!(oper.equals("(")) && !(st.empty())) {
                    postfixString += oper;
                    st.pop();
                    oper = st.peek();
                }
                st.pop(); // 여는 괄호는 pop하여 버림
            }

            // + 또는 - 연산자를 만나면 스택에서 우선순위가 낮은 연산자를 pop하여 후위 표기법에 추가 후 자신을 push
            else if (chValue == '+' || chValue == '-') {
                if (st.empty()) {
                    st.push(chValue + "");
                } else {
                    String oper = st.peek();
                    while (!(st.empty() || oper.equals("(")) || oper.equals(")")) {
                        oper = st.pop();
                        postfixString += oper;
                    }
                    st.push(chValue + "");
                }
            }

            // * 또는 / 연산자를 만나면 스택에서 우선순위가 낮은 연산자를 pop하여 후위 표기법에 추가 후 자신을 push
            else if (chValue == '*' || chValue == '/') {
                if (st.empty()) {
                    st.push(chValue + "");
                } else {
                    String oper = st.peek();
                    while (!oper.equals("+") && !oper.equals("-") && !st.empty()) {
                        oper = st.pop();
                        postfixString += oper;
                    }
                    st.push(chValue + "");
                }
            }

            // 피연산자인 경우 바로 후위 표기법에 추가
            else {
                postfixString += chValue;
            }
        }

        // 스택에 남은 모든 연산자를 pop하여 후위 표기법에 추가
        while (!st.empty()) {
            String oper = st.peek();
            if (!oper.equals("(")) {
                oper = st.pop();
                postfixString += oper;
            }
        }

        return postfixString; // 후위 표기법으로 변환된 수식 반환
    }
}
