public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(FibonacciRecursive(10));
        System.out.println(FibonacciLooped(10));
    }

    public static int FibonacciRecursive(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    public static int FibonacciLooped(int n) {
        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 1; i < n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }
}
