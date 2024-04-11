public class s240305_3 {
    public static void main(String[] args) {
        for(int i = 1; i<=20; i++) {
            System.out.printf("%2d!= %d\n",i,Fib(i));
        }
    }
    public static long Fib(int n) { // 재귀함수 정의의 의미 : n번째 피보나치 수 반환
        if ( n<=1 )
            return n; // base case, 탈출구
        return Fib(n-1) + Fib(n-2); // recursive case, 함수 정의와 의미 동일
    }
}
// 자바자료구조 1-3 재귀함수(피보나치)

