package s240326_과제;

import java.util.Scanner;
import java.util.Stack;


public class StackBin {
    static void Stackbin(int val) {
        Stack<Integer> tmp = new Stack<>();
        while(true) {
            if(val <= 1) {
                tmp.push(val);
                break;
            }
            tmp.push(val % 2);
            val = val / 2;
        }
        int size = tmp.size();
        for (int i=0; i< size; i++) {
            System.out.print(tmp.pop());
        }
    }

}

class STACKBINTEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력 : ");
        int dec = sc.nextInt();
        StackBin.Stackbin(dec);
    }
}
