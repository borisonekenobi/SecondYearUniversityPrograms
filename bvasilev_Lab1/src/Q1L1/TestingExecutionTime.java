package Q1L1;

import java.text.DecimalFormat;
import java.util.Scanner;

// Class TestingExecutionTime
public class TestingExecutionTime {
    // Scanner variable
    public static Scanner input = new Scanner(System.in);

    // Constructor (unneeded but defined in UML diagram)
    public TestingExecutionTime() { }

    // main method
    public static void main(String[] args) {
        myHeader(1);

        int num;
        do {
            System.out.print("Enter an integer number: ");
            num = input.nextInt();
        } while (num < 0);

        //iterative solution inside main
        DecimalFormat format = new DecimalFormat("0.##E0");
        long ns = System.nanoTime();
        double factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        System.out.printf("%d! = %s\n", num, format.format(factorial));
        System.out.printf("Time taken by iterative solution inside main: %.4fms\n", (System.nanoTime() - ns) / 1_000_000d);

        //iterative method call
        ns = System.nanoTime();
        System.out.printf("%d! = %s\n", num, format.format(iterativeMethodForFactorial(num)));
        System.out.printf("Time taken by iterative method call: %.4fms\n", (System.nanoTime() - ns) / 1_000_000d);

        //recursive method call
        ns = System.nanoTime();
        System.out.printf("%d! = %s\n", num, format.format(recursiveMethodForFactorial(num)));
        System.out.printf("Time taken by recursive method call: %.4fms\n", (System.nanoTime() - ns) / 1_000_000d);

        myFooter(1);
    }

    // myHeader method
    public static void myHeader(int i) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q1
                Prepared By: Boris Vasilev
                Student Number: 251276924
                Goal of this Exercise: Checking the code-execution time!
                =======================================================
                """, i);
    }

    //myFooter method
    public static void myFooter(int i) {
        System.out.printf("""
                =======================================================
                Completion of Lab Exercise %d-Q1 is successful!
                Signing off - Boris
                =======================================================
                """, i);
    }

    //iterative method to calculate factorial of int i
    public static double iterativeMethodForFactorial(int num) {
        double factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //recursive method to calculate factorial of int i
    public static double recursiveMethodForFactorial(int num) {
        if (num <= 1) return 1;
        return num * recursiveMethodForFactorial(num - 1);
    }
}
