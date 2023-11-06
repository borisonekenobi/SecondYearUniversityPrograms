package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenericsAndArrays_Boris {
    public static void main(String[] args) {
        myHeader(2);

        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4. To see the list of the students from a specific year enter an integer between 2 and 4 when prompted");

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));
        Pair<Integer, String>[] pairs = new Pair[nums.size()];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair<>(nums.get(i), names.get(i));
        }

        String continueCode;
        do {
            Scanner input = new Scanner(System.in);
            int year;
            while (true) {
                System.out.print("Enter Academic Year (2, 3 or 4): ");
                String userInput = input.nextLine();
                if (userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
                    year = Integer.parseInt(userInput);
                    break;
                }
                System.out.print("Incorrect input! ");
            }

            ArrayList<String> tempLst = new ArrayList<>();
            for (Pair<Integer, String> pair : pairs) {
                if (pair.getKey() == year) tempLst.add(pair.getValue());
            }
            System.out.printf("Found %d leader(s) from year %d.\nHere is the list:\n%s\n", tempLst.size(), year, tempLst);

            do {
                System.out.print("Do you wish to continue? (y/N) ");
                continueCode = input.nextLine().toLowerCase();
            } while (!(continueCode.equals("y") || continueCode.equals("n") || continueCode.isEmpty()));

        } while (continueCode.equals("y"));

        myFooter(2);
    }

    private static void myHeader(int i) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q1
                Prepared By: Boris Vasilev
                Student Number: 251276924
                Goal of this Exercise: Using generics to create array of students!
                =======================================================
                """, i);
    }

    private static void myFooter(int i) {
        System.out.printf("""
                =======================================================
                Completion of Lab Exercise %d-Q1 is successful!
                Signing off - Boris
                =======================================================
                """, i);
    }
}
