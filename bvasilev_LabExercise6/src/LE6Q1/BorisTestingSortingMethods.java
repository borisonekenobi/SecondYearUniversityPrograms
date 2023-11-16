package LE6Q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BorisTestingSortingMethods {
    private static final int MIN_SIZE = 10;
    private static final int sz = 50_000;

    /**
     * The driver method
     *
     * @param args Arguments passed when running the program (ignored in this case)
     */
    public static void main(String[] args) {
        myHeader(6, 1);

        Integer[] arr = new Integer[sz];

        Integer[] backup = new Integer[sz];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 81 + 13);
        }

        System.arraycopy(arr, 0, backup, 0, sz);

        List<Integer> list = Arrays.asList(arr);

        System.out.printf("Testing execution time of different sorting methods for sorting %d random numbers:\n", sz);
//        System.out.printf("The unsorted list: %s\n", list);
        long startTime = System.nanoTime();
        Collections.sort(list);
        long elapsedTimeMicroSec = (System.nanoTime() - startTime) / 1_000;
        System.out.printf("Collections' Sorting Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list using Collections' sort method: %s\n\n", list);

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = selectionSort(arr) / 1_000;
        System.out.printf("My Selection-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list using selection-sort: %s\n\n", Arrays.toString(arr));

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = bubbleSort(arr) / 1_000;
        System.out.printf("My Bubble-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list with Bubble-sort: %s\n\n", Arrays.toString(arr));

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = insertionSort(arr) / 1_000;
        System.out.printf("My Insertion-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list with Insertion-sort: %s\n\n", Arrays.toString(arr));

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = mergeSort(arr) / 1_000;
        System.out.printf("My Merge-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list with Merge-sort: %s\n\n", Arrays.toString(arr));

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = quickSort(arr, 0, arr.length - 1) / 1_000;
        System.out.printf("My Quick-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list with Quick sort: %s\n\n", Arrays.toString(arr));

        System.arraycopy(backup, 0, arr, 0, sz);

//        System.out.printf("The unsorted list: %s\n", Arrays.toString(arr));
        elapsedTimeMicroSec = bucketSort(arr, 0, arr.length - 1, 2) / 1_000;
        System.out.printf("My Bucket-Sort Time: %dμs (~%.2fms)\n", elapsedTimeMicroSec, elapsedTimeMicroSec / 1_000d);
//        System.out.printf("The sorted list with Bucket-sort: %s\n\n", Arrays.toString(arr));

        myFooter(6, 1);
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
                Goal of this Exercise: To show the use of several sorting methods using an Integer array
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

    /**
     * Implementation of the Selection Sorting algorithm
     *
     * @param a The array to be sorted
     * @return Time in nanoseconds (ns) that the sorting algorithm took to complete
     */
    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long startTime = System.nanoTime();

        for (int outerIndex = 0; outerIndex < a.length; outerIndex++) {
            int indexOfNextSmallest = outerIndex;
            for (int innerIndex = outerIndex + 1; innerIndex < a.length; innerIndex++) {
                if (a[innerIndex].compareTo(a[indexOfNextSmallest]) < 0) {
                    indexOfNextSmallest = innerIndex;
                }
            }
            T temp = a[outerIndex];
            a[outerIndex] = a[indexOfNextSmallest];
            a[indexOfNextSmallest] = temp;
        }

        return System.nanoTime() - startTime;
    }

    /**
     * Implementation of the Bubble Sorting algorithm
     *
     * @param a The array to be sorted
     * @return Time in nanoseconds (ns) that the sorting algorithm took to complete
     */
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long startTime = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        return System.nanoTime() - startTime;
    }

    /**
     * Implementation of the Insertion Sorting algorithm
     *
     * @param a The array to be sorted
     * @return Time in nanoseconds (ns) that the sorting algorithm took to complete
     */
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long startTime = System.nanoTime();

        insertionSort(a, 0, a.length - 1);

        return System.nanoTime() - startTime;
    }

    /**
     * Implementation of the Insertion Soring algorithm
     *
     * @param a     The array to be sorted
     * @param first The position of the first element to be sorted
     * @param last  The position of the last element to be sorted
     */
    private static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
        for (int i = first + 1; i <= last; i++) {
            T key = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j].compareTo(key) > 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    /**
     * Implementation of the Merge Sorting algorithm
     *
     * @param S The array to be sorted
     * @return Time in nanoseconds (ns) that the sorting algorithm took to complete
     */
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long startTime = System.nanoTime();

        int n = S.length;
        if (n < 2) return System.nanoTime() - startTime;

        int mid = n / 2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid);
        T[] S2 = Arrays.copyOfRange(S, mid, n);

        mergeSort(S1);
        mergeSort(S2);

        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }


        return System.nanoTime() - startTime;
    }

    /**
     * Implementation of the Quick Soring algorithm
     *
     * @param a     The array to be sorted
     * @param first The position of the first element to be sorted
     * @param last  The position of the last element to be sorted
     */
    public static <T extends Comparable<? super T>> long quickSort(T[] a, int first, int last) {
        long startTime = System.nanoTime();

        if (last - first + 1 < MIN_SIZE) {
            insertionSort(a, first, last);
        } else {
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, last);
        }

        return System.nanoTime() - startTime;
    }

    /**
     * Partitions an array as part of quick sort into two sub-arrays
     * called Smaller and Larger that are separated by a single
     * element called the pivot.
     * Elements in Smaller are <= pivot and appear before the
     * pivot in the array.
     * Elements in Larger are >= pivot and appear after the
     * pivot in the array.
     *
     * @param a     an array of Comparable objects
     * @param first the integer index of the first array element; first >= 0 and < a.length
     * @param last  the integer index of the last array element; last - first >= 3; last < a.length
     * @return the index of the pivot
     */
    private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
        int mid = (first + last) / 2;
        sortFirstMiddleLast(a, first, mid, last);
        swap(a, mid, last - 1);
        int pivotIndex = last - 1;
        T pivot = a[pivotIndex];
        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;
        boolean done = false;
        while (!done) {
            while (a[indexFromLeft].compareTo(pivot) < 0)
                indexFromLeft++;
            while (a[indexFromRight].compareTo(pivot) > 0)
                indexFromRight--;
            assert a[indexFromLeft].compareTo(pivot) >= 0 &&
                    a[indexFromRight].compareTo(pivot) <= 0;
            if (indexFromLeft < indexFromRight) {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            } else
                done = true;
        }

        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        return pivotIndex;
    }

    /**
     * Task: Sorts the first, middle, and last elements of an array into ascending order.
     *
     * @param a     an array of Comparable objects
     * @param first the integer index of the first array element; first >= 0 and < a.length
     * @param mid   the integer index of the middle array element
     * @param last  the integer index of the last array element; first >= 2, last < a.length
     */
    private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
        order(a, first, mid);
        order(a, mid, last);
        order(a, first, mid);
    }

    /**
     * Orders two given array elements into ascending order so that a[i] <= a[j].
     *
     * @param a an array of Comparable objects
     * @param i an integer >= 0 and < array.length
     * @param j an integer >= 0 and < array.length
     */
    private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
        if (a[i].compareTo(a[j]) > 0)
            swap(a, i, j);
    }

    /**
     * Swaps the array elements array[i] and array[j].
     *
     * @param array The array where the elements are being swapped.
     * @param i     The index of the first element.
     * @param j     The index of the second element.
     */
    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Implementation of the Bucket (Radix) Sorting algorithm.
     *
     * @param a         The array to be sorted.
     * @param first     The index of the first element to be sorted.
     * @param last      The index of the last element to be sorted.
     * @param maxDigits The maximum number of digits the Integers in the array can have.
     * @return The time in nanoseconds (ns) it took to sort the array.
     */
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        long startTime = System.nanoTime();

        Vector<Integer>[] bucket = new Vector[10];
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }

            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }

            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        return System.nanoTime() - startTime;
    }

    /**
     * Extracts the ith digit from a decimal number.
     *
     * @param number The number that the digits is extracted from.
     * @param i The position of the digit to be extracted.
     * @return The digit that was extracted
     */
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }
}
