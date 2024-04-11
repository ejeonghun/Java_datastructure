public class s240305_4 {
    public static void main(String[] args) {
        System.out.printf("1에서 10까지의 역수들의 합 : %f",revSum(10));
    }

    public static double revSum(int n) {
        if (n == 1)
            return 1.0;
        return revSum(n-1) + 1.0/n;
    }
}
