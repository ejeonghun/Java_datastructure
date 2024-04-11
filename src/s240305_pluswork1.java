public class s240305_pluswork1 {
    // 추가 실습 반복문으로 n번째 피보나치 수열을 반환하는 함수 작성
    public static void main(String[] args) {
        int N = 10;
        int res = 0;
        int a, b;
        a = 0; b = 1;


        for (int i = 2; i <= N; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        System.out.println(res);
    }
}
