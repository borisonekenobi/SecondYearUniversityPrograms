package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    /**
     * Driver method.
     * @param args an array of String type variables containing the configuration arguments given to the main method.
     */
    public static void main(String[] args) {
        myHeader(new Student(), 4, 2);

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student());

        students.add(new Student("Harry", "Potter", 75.50));
        students.add(new Student("Ronald", "Weasley", 86.00));
        students.add(new Student("Hermione", "Granger", 91.70));
        students.add(new Student("Parvati", "Patil", 93.75));

        System.out.println("The Score Card:");
        for (Student student : students) System.out.printf("\t%s\n", student.toString());
        System.out.println();

        Collections.sort(students, Collections.reverseOrder());
        System.out.println("The sorted list in terms of score in descending order....");
        for (Student student : students) System.out.printf("\t%s\n", student.toString());
        System.out.println();

        Collections.sort(students, new HelperClassCompareLastNames());
        System.out.println("The sorted list in terms of Last Names....");
        for (Student student : students) System.out.printf("\t%s\n", student.toString());
        System.out.println();

        Collections.sort(students, new HelperClassCompareFirstNames());
        System.out.println("The sorted list in terms of First Names....");
        for (Student student : students) System.out.printf("\t%s\n", student.toString());
        System.out.println();

        myFooter(4, 2);
    }

    /**
     * Used at the beginning of the code to show who wrote the code and the goal of the exercise.
     * @param myInfo The author of this code
     * @param labE_number Lab Exercise number
     * @param q_number Question number
     */
    public static void myHeader(Student myInfo, int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q%d
                Prepared By: %s %s
                Student Number: 251276924
                Goal of this Exercise: To demo the Comparable<T> and Comparator<T> classes
                =======================================================
                """, labE_number, q_number, myInfo.getFirstName(), myInfo.getLastName());
    }

    /**
     * Used at the end of the code to signify a successful completion.
     * @param labE_number Lab Exercise number
     * @param q_number Question number
     */
    public static void myFooter(int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Completion of Lab Exercise %d-Q%d is successful!
                Signing off - Boris
                =======================================================
                """, labE_number, q_number);
    }
}
