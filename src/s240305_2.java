public class s240305_2 {
    // 재귀함수
    public static void main(String[] args) {
        System.out.println(Factorial(20));
    }
    public static long Factorial(int n) { // 재귀함수 정의의 의미 : n! 반환
        if ( n<1 )
            return 1; // base case, 탈출구
        return n * Factorial(n-1); // recursive case, 함수정의와 의미 동일( n * (n-1)! == n!)
    }
}
// 자바자료구조 1-2 재귀함수(팩토리얼)