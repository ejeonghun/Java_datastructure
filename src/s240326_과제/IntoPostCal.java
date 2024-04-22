package s240326_과제;

import java.util.ArrayList;
import java.util.Stack;

public class IntoPostCal {
    public static void main(String[] args) {
        String str = "15+30-32/16"; // 중위식 입력
        System.out.println("중위식: " + str);
        ArrayList<String> postfixArray = InToPost(str);
        System.out.print("후위식: "); // 후위식 출력
        for (String p : postfixArray) {
            System.out.print(p + " ");
        }
        evalPostfix(postfixArray); // 후위식 계산 결과 출력
    }

    public static ArrayList<String> InToPost(String infixString) { // 중위식=> 후위식
        Stack<String> st = new Stack<>(); // 자바Stack 객체 생성
        ArrayList<String> postfixArray = new ArrayList<>();
        String num = "";

        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);

            if (!(chValue >= 48 && chValue <= 57) && chValue != '(' && chValue != ')') {
                postfixArray.add(num);
                num = "";
            }

            if (chValue == '(') { // 여는 괄호는 무조건 스택에 푸시
                st.push("(");
            }

            // 닫는 괄호를 만나면 스택에서 여는 괄호를 만나때 까지 팝[반복]
            else if (chValue == ')') {
                String oper = st.peek();
                while (!(oper.equals("(")) && !(st.empty())) {
                    postfixArray.add(oper);
                    st.pop();
                    oper = st.peek();
                }
                st.pop();
            }

            // 연산자는 스택의 연산자와 우선순위 비교
            else if (chValue == '+' || chValue == '-') {
                if (st.empty()) {
                    st.push(chValue + "");
                } else {
                    String oper = st.peek();
                    while (!(st.empty() || oper.equals("(")) || oper.equals(")")) {
                        oper = st.pop();
                        postfixArray.add(oper);
                    }
                    st.push(chValue + "");
                }
            } else if (chValue == '*' || chValue == '/') {
                if (st.empty()) {
                    st.push(chValue + "");
                } else {
                    String oper = st.peek();
                    while (!oper.equals("+") && !oper.equals("-") && !st.empty()) {
                        oper = st.pop();
                        postfixArray.add(oper);
                    }
                    st.push(chValue + "");
                }
            } else {
                num += chValue + "";
            }
        }

        postfixArray.add(num);

        // 스택에 남은 모든 연산자를 팝[반복]
        while (!st.empty()) {
            String oper = st.peek();
            if (!oper.equals("(")) {
                oper = st.pop();
                postfixArray.add(oper);
            }
        }

        return postfixArray;
    }

    public static void evalPostfix(ArrayList<String> postfix) {
        int num1 = 0, num2 = 0;
        Stack<Integer> stack = new Stack<>(); // 자바Stack 객체 생성

        for (String s : postfix) {
            // 연산자이면 스택에서 피연산자2개를 꺼낸후, 계산 결과를 다시 스택에 입력
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                char oper = s.charAt(0);
                num2 = stack.pop();
                num1 = stack.pop();
                switch (oper) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            } else { // 피연산자이면 스택에 푸시
                stack.push(Integer.parseInt(s));
            }
        }

        // 스택에 남은 최종 결과 출력
        System.out.println("\n결과값: " + stack.pop());
    }
}
