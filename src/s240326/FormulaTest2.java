package s240326;

import java.util.Stack;
public class FormulaTest2 {
    public static void main(String[] args) {
        String postfix = "82/3-32*+"; // 후위식 입력
        System.out.println("후위식 : " + postfix);
        evalPostfix(postfix); // 후위식 계산 결과 출력
    }

    public static void evalPostfix(String postfix){
        char testCh=' ' ;
        int expSize = postfix.length();
        int num1=0, num2=0;
        Stack<Integer> stack = new Stack<>(); // 자바 Stack 객체 생성

        for(int i=0; i<expSize; i++){
            testCh = postfix.charAt(i);
// 연산자이면 스택에서 피연산자 2개를 꺼낸후, 계산 결과를 다시 스택에 입력
            if(testCh=='+' || testCh=='-' || testCh=='*' || testCh=='/'){
                num2 = stack.pop();
                num1 = stack.pop();

                switch(testCh){
                    case '+' :
                        stack.push(num1+num2);
                        break;
                    case '-' :
                        stack.push(num1-num2);
                        break;
                    case '*' :
                        stack.push(num1*num2);
                        break;
                    case '/' :
                        stack.push(num1/num2);
                        break;
                }
            }else{ // 피연산자이면 스택에 푸시
                stack.push(testCh-'0');
            }
        }
        // 스택에 남은 최종 결과 출력
        System.out.println("결과값 : " + stack.pop());
    }
}