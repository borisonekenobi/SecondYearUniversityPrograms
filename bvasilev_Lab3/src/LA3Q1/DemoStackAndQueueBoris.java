package LA3Q1;

import java.util.Scanner;

public class DemoStackAndQueueBoris {
    public static Scanner input = new Scanner(System.in);

    // myHeader method
    private static void myHeader(int i) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q1
                Prepared By: Boris Vasilev
                Student Number: 251276924
                Goal of this Exercise: To demo how stacks and queues work!
                =======================================================
                """, i);
    }

    // myFooter method
    private static void myFooter(int i) {
        System.out.printf("""
                =======================================================
                Completion of Lab Exercise %d-Q1 is successful!
                Signing off - Boris
                =======================================================
                """, i);
    }

    // Demoing the stack feature
    public static void stackDemo(BorisArray bArray) {
        System.out.printf("You have an empty stack: %s\n\n", bArray);

        while (true) {
            String curIn;
            do {
                System.out.print("Stack Operation Menu:\na: Push\nb: Pop\nc:Exit\nEnter your choice: ");
                curIn = input.nextLine().toLowerCase();
                if (curIn.equals("a") || curIn.equals("b") || curIn.equals("c")) break;
                else System.out.println("Invalid choice!\n");
            } while (true);

            // Pushing new element into bArray
            if (curIn.equals("a")) {
                System.out.println("Let's push a data-item into the stack....");
                int year;
                do {
                    System.out.print("Enter year: ");
                    try {
                        year = Integer.parseInt(input.nextLine());
                        break;
                    } catch (Exception ex) {
                        System.out.println("Invalid input!");
                    }
                } while (true);
                System.out.print("Enter name: ");
                String name = input.nextLine();
                bArray.addAtLastIndex(new Pair<>(year, name));
                System.out.printf("The current stack: %s\n\n", bArray);
            }

            // Popping element from bArray
            else if (curIn.equals("b")) {
                System.out.println("Let's pop a data-item ....");
                if (bArray.getSize() <= 0) System.out.println("FYI: The stack is empty!\n");
                else {
                    System.out.printf("%s is removed! The current stack: %s\n\n", bArray.removeFromLastIndex(), bArray);
                }
            }

            // Ending stack demo
            else {
                System.out.println("Ending Stack-demo! Goodbye\n");
                return;
            }
        }
    }

    // Demoing the queue feature
    public static void queueDemo(BorisArray bArray) {
        System.out.printf("You have an empty queue: %s\n\n", bArray);

        while (true) {
            String curIn;
            do {
                System.out.print("Stack Operation Menu:\na: Enqueue\nb: Dequeue\nc:Exit\nEnter your choice: ");
                curIn = input.nextLine().toLowerCase();
                if (curIn.equals("a") || curIn.equals("b") || curIn.equals("c")) break;
                else System.out.println("Invalid choice!\n");
            } while (true);

            // Enqueuing new element to bArray
            if (curIn.equals("a")) {
                System.out.println("Let's enqueue a data-item into the queue....");
                int year;
                do {
                    System.out.print("Enter year: ");
                    try {
                        year = Integer.parseInt(input.nextLine());
                        break;
                    } catch (Exception ex) {
                        System.out.println("Invalid input!");
                    }
                } while (true);
                System.out.print("Enter name: ");
                String name = input.nextLine();
                bArray.addAtLastIndex(new Pair<>(year, name));
                System.out.printf("The current queue: %s\n\n", bArray);
            }

            // Popping element from bArray
            else if (curIn.equals("b")) {
                System.out.println("Let's dequeue a data-item ....");
                if (bArray.getSize() <= 0) System.out.println("FYI: The queue is empty!\n");
                else {
                    System.out.printf("%s is removed! The current queue: %s\n\n", bArray.removeFromFirstIndex(), bArray);
                }
            }

            // Ending queue demo
            else {
                System.out.println("Ending Queue-demo! Goodbye\n");
                return;
            }
        }
    }

    // main method
    public static void main(String[] args) {
        myHeader(3);

        System.out.println("\nThis code preforms a demo for Stack and Queue:\n");

        while (true) {
            BorisArray bArray = new BorisArray();
            String curIn;
            Pair<Integer, String>[] options = new Pair[]{new Pair<>(1, "Stack"), new Pair<>(2, "Queue"), new Pair<>(3, "Exit")};
            do {
                System.out.println("Main Demo-Menu:");
                for (Pair<Integer, String> option : options) {
                    System.out.printf("\t%d: %s\n", option.getKey(), option.getValue());
                }
                System.out.print("Enter your choice: ");
                curIn = input.nextLine();
                if (curIn.equals("1") || curIn.equals("2") || curIn.equals("3")) break;
                else System.out.println("Invalid choice!\n");
            } while (true);

            System.out.println();
            if (curIn.equals("1")) stackDemo(bArray);
            else if (curIn.equals("2")) queueDemo(bArray);
            else break;
        }
        System.out.println("Goodbye!\n");

        myFooter(3);
    }
}
