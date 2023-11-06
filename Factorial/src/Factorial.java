public class Factorial {
    public static void main(String[] args) {
        System.out.println(FactorialRecursive(30));
        System.out.println(FactorialLooped(30));
    }

    public static double FactorialRecursive(int n) {
        if (n == 1) return 1;
        return n * FactorialRecursive(n - 1);
    }

    public static double FactorialLooped(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
