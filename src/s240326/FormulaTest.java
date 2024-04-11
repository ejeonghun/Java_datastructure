package s240326;

import java.util.Stack;
class Formula {
    private String exp;
    private int expSize;
    private char testCh, openPair;
    public boolean checkMatching(String exp){ // 괄호쌍 체크 메소드 : 올바르면 true 반환
        this.exp = exp;
        Stack<Character> stack = new Stack<>(); // 문자형객체 Stack 생성
        expSize = this.exp.length();
        for(int i=0; i<expSize; i++){
            testCh = exp.charAt(i);
            switch(testCh){ // 여는 괄호면 스택에 푸시
                case '(' :
                case '[' :
                case '{' :
                    stack.push(testCh); // 오토박싱, char 기초형이 Character 객체로 변환되어 저장
                    break;
                case ')' : // 닫는 괄호면 스택에서 팝 후, 괄호쌍 매칭 검사
                case ']' :
                case '}' :
                    if(stack.empty()){
                        return false;
                    }else{
                        openPair = stack.pop();
                        if( openPair=='(' && testCh!=')' ||
                                openPair=='{' && testCh!='}' ||
                                openPair=='[' && testCh!=']' ) {
                            return false;
                        } else {
                            break;
                        }
                    }
            }
        }

        if(stack.empty()) // 수식을 모두 읽은 후, 스택이 비어 있으면 오케이
            return true;
        else
            return false;
    }
}
public class FormulaTest {
    public static void main(String[] args) {
        Formula op = new Formula();
        String exp = "{(A+B)-3}*5+[{cos(x+y)+7}-1]*4";
        System.out.println(exp);

        if(op.checkMatching(exp))
            System.out.println("수식이 올바름(괄호의 쌍이 일치)");
        else
            System.out.println("수식이 올바르지 않음(괄호의 쌍이 불일치)");

    }
}