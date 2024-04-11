package s240326;

import java.util.Stack;
public class Infix2Postfix {
    public static void main(String[] args) {
        String str = "2*3+(2-4)/2"; // 중위식 입력
        System.out.println("중위식 : " + str);
        System.out.println("후위식 : " + InToPost(str)); // 후위식 출력
    }
    public static String InToPost(String infixString) { // 중위식 => 후위식
        Stack<String> st = new Stack<>(); // 자바 Stack 객체 생성
        String postfixString = " ";
        for (int index = 0; index < infixString.length(); ++index) {
            char chValue = infixString.charAt(index);
            if (chValue == '(') { // 여는 괄호는 무조건 스택에 푸시
                st.push("(");
            }
            // 닫는 괄호를 만나면 스택에서 여는 괄호를 만나때 까지 팝[반복]
            else if (chValue == ')') {
                String oper = st.peek();
                while (!(oper.equals("(")) && !(st.empty())) {
                    postfixString += oper;
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
                    while (!(st.empty() || oper.equals("(")) ||
                            oper.equals(")")) {
                        oper = st.pop();
                        postfixString += oper;
                    }
                    st.push(chValue + "");
                }
            } else if (chValue == '*' || chValue == '/') {
                if (st.empty()) {
                    st.push(chValue + "");
                } else {
                    String oper = st.peek();
                    while (!oper.equals("+") && !oper.equals("-") &&
                            !st.empty()) {
                        oper = st.pop();
                        postfixString += oper;
                    }
                    st.push(chValue + "");
                }
            } else {
                postfixString += chValue;
            }
        }
        // 스택에 남은 모든 연산자를 팝[반복]
        while (!st.empty()) {
            String oper = st.peek();
            if (!oper.equals("(")) {
                oper = st.pop();
                postfixString += oper;
            }
        }
        return postfixString;
    }
}