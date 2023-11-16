package LE6Q2;

import java.util.Collections;
import java.util.Vector;

public class Boris_SortNameAndGrade {
    /**
     * The driver method
     *
     * @param args Arguments passed when running the program (ignored in this case)
     */
    public static void main(String[] args) {
        myHeader(6, 2);

        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26)};

        Vector<StudentGrade> sg = new Vector<>();
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        System.out.println();
        System.out.println("The Unsorted Array ................");
        for (StudentGrade s : sg) System.out.println(s);
        System.out.println();

        Collections.sort(sg);
        System.out.println("Sorted by Grades......................");
        for (StudentGrade s : sg) System.out.println(s);
        System.out.println();

        StudentGrade[] grades = new StudentGrade[fnArray.length];
        sg.copyInto(grades);

        System.out.println("Sorted by First Names .............");
        sort(grades, 1);
        printArray(grades);
        System.out.println();

        System.out.println("Sorted by Last Names...............");
        sort(grades, 2);
        printArray(grades);
        System.out.println();

        myFooter(6, 2);
    }

    /**
     * Implementation of the Insertion Sorting algorithm made for sorting StudentGrades
     *
     * @param studentGrades The array of StudentGrades to be sorted
     * @param key           Determines which name to sort the array by<br>
     *                      key = 1 -> first name<br>
     *                      key = 2 -> last name
     */
    private static void sort(StudentGrade[] studentGrades, int key) {
        int first = 0;
        int last = studentGrades.length - 1;

        if (key == 1) {
            for (int i = first + 1; i <= last; i++) {
                StudentGrade temp = studentGrades[i];
                int j;
                for (j = i - 1; j >= 0 && studentGrades[j].getFirstName().compareTo(temp.getFirstName()) > 0; j--) {
                    studentGrades[j + 1] = studentGrades[j];
                }
                studentGrades[j + 1] = temp;
            }
        } else {
            for (int i = first + 1; i <= last; i++) {
                StudentGrade temp = studentGrades[i];
                int j;
                for (j = i - 1; j >= 0 && studentGrades[j].getLastName().compareTo(temp.getLastName()) > 0; j--) {
                    studentGrades[j + 1] = studentGrades[j];
                }
                studentGrades[j + 1] = temp;
            }
        }
    }

    /**
     * Prints the contents of a StudentGrade array
     *
     * @param studentGrades The array of StudentGrades to be printed
     */
    private static void printArray(StudentGrade[] studentGrades) {
        for (StudentGrade s : studentGrades) System.out.println(s);
    }

    /**
     * Used at the beginning of the code to show who wrote the code and the goal of the exercise.
     *
     * @param labE_number Lab Exercise number
     * @param q_number    Question number
     */
    public static void myHeader(int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q%d
                Prepared By: %s %s
                Student Number: 251276924
                Goal of this Exercise: To show the use of sorting methods with custom objects
                =======================================================
                """, labE_number, q_number, "Boris", "Vasilev");
    }

    /**
     * Used at the end of the code to signify a successful completion.
     *
     * @param labE_number Lab Exercise number
     * @param q_number    Question number
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
