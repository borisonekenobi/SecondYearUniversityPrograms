package Q2L1;

import java.util.Scanner;

//Class WorkingWithArrays
public class WorkingWithArrays {
    // Scanner variable
    public static Scanner input = new Scanner(System.in);

    // Constructor (unneeded but defined in UML diagram)
    public WorkingWithArrays() { }

    //main method
    public static void main(String[] args) {
        myHeader(1);

        int N;
        do {
            System.out.print("Enter array size: ");
            N = input.nextInt();
        } while (N <= 0);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter value %d: ", i + 1);
            arr[i] = input.nextInt();
        }

        System.out.println("\nHere is the result......");
        double[] nums = mma5MethodBoris(arr);

        System.out.printf("The max is %.2f.\n", nums[0]);
        System.out.printf("The min is %.2f.\n", nums[1]);
        System.out.printf("The average of the 'divisible by 5 numbers' is %.2f.\n", nums[2]);
        System.out.printf("My student number is %.0f.\n", nums[3]);

        myFooter(1);
    }

    // myHeader method
    public static void myHeader(int i) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q2
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
                Completion of Lab Exercise %d-Q2 is successful!
                Signing off - Boris
                =======================================================
                """, i);
    }

    public static double[] mma5MethodBoris(int[] arr) {
        double maxValue = arr[0];
        double minValue = arr[0];
        double averageValue = 0;
        double StudentNumber = 251276924d;
        
        double sum = 0;
        int length = 0;

        for (int num : arr) {
            if (num % 5 != 0) continue;
            sum += num;
            length++;
            if (num > maxValue) maxValue = num;
            if (num < minValue) minValue = num;
        }

        if (length > 0) {
            averageValue = sum / length;
            System.out.printf("Boris found %d numbers that are divisible by 5\n", length);
        } else {
            System.out.println("\nIn the array, there was no number ‘divisible by 5’ and hence the average remains 0.00.");
        }

        return new double[] { maxValue, minValue, averageValue, StudentNumber };
    }
}
