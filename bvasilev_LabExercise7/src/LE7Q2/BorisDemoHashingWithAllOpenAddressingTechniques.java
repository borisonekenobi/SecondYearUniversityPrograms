package LE7Q2;

import LE7Q1.*; // this will import classes from the Q1 package

import java.util.Arrays;

import static LE7Q1.BorisDemoHashingWithLinearProbing.*; // this will import all the static fields and methods from the driver class of the Q1 package

public class BorisDemoHashingWithAllOpenAddressingTechniques {
    /**
     * Adds key to hash table using quadratic probing collision resolving technique
     * @param key The key to be added to the hash table
     */
    public static void addValueQuadraticProbe(Integer key) {
        int len = hashTable.length;
        int hash = key.hashCode();

        for (int i = 0; i < len; i++) {
            int index = (hash + i * i) % len;
            if (index < 0) index += len;

            if (hashTable[index].getKey() == null || hashTable[index].getKey() == AVAILABLE) {
                hashTable[index] = new BorisValueEntry(key);
                return;
            }
        }
    }

    /**
     * Adds key to hash table using double-hashing collision resolving technique
     * @param key The key to be added to the hash table
     */
    public static void addValueDoubleHashing(Integer key) {
        int q = thePrimeNumberForSecondHashFunction(hashTable.length);
        int primaryHash = Math.abs(key.hashCode() % hashTable.length);
        int secondaryHash = Math.abs(q - (key % q));

        for (int j = 0; j < hashTable.length; j++) {
            int index = (primaryHash + j * secondaryHash) % hashTable.length;

            if (hashTable[index].getKey() == null || hashTable[index].getKey() == AVAILABLE) {
                hashTable[index] = new BorisValueEntry(key);
                return;
            }
        }

        throw new IllegalStateException("Couldn't find empty spot for new element");
    }

    /**
     * Generates the prime number for the second hash function
     * @param tableCapacity The capacity of the hash table
     * @return The generated prime number
     */
    public static int thePrimeNumberForSecondHashFunction(int tableCapacity) {
        for (int i = tableCapacity - 1; i > 2; i--) {
            int m = i / 2;
            boolean isPrime = true;
            for (int j = 3; j <= m; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) return i;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Empties the hash table
     */
    public static void emptyHashTable() {
        Arrays.fill(hashTable, new BorisValueEntry());
    }

    /**
     * Prints the contents of the provided array
     * @param array The array to be printed
     */
    public static void printArray(Integer[] array) {
        System.out.print("[");
        for (Integer integer : array) {
            String key;
            if (integer == null) key = null;
            else if (integer == AVAILABLE) key = "available";
            else key = integer.toString();
            System.out.printf("%s, ", key);
        }
        System.out.println("\b\b]");
    }

    /**
     * The driver method
     *
     * @param args Arguments passed when running the program (ignored in this case)
     */
    public static void main(String[] args) {
        myHeader(7, 2);

        System.out.println("Let's demonstrate our understanding on all the open addressing techniques...");
        System.out.print("How many data items: ");
        items = Integer.parseInt(input.nextLine());
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = Double.parseDouble(input.nextLine());
        tableCapacity = checkPrime((int) Math.ceil(items / lf));
        hashTable = new BorisValueEntry[tableCapacity];
        emptyHashTable();
        System.out.printf("The minimum required table capacity would be: %d\n", hashTable.length);
        Integer[] arr = new Integer[] { -11, 22, -33, -44, 55 };
        System.out.print("The given dataset is: ");
        printArray(arr);
        System.out.println();

        System.out.println("Adding data - linear probing resolves collision");
        for (Integer integer : arr) {
            addValueLinearProbe(integer);
        }
        printHashTable();
        System.out.println();

        emptyHashTable();
        System.out.println("Adding data - quadratic probing resolves collision");
        for (Integer integer : arr) {
            addValueQuadraticProbe(integer);
        }
        if (lf > 0.5) System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        printHashTable();
        System.out.println();

        emptyHashTable();
        System.out.println("Adding data - double-hashing resolves collision");
        System.out.printf("The q value for double hashing is: %d\n", thePrimeNumberForSecondHashFunction(hashTable.length));
        for (Integer integer : arr) {
            addValueDoubleHashing(integer);
        }
        printHashTable();

        myFooter(7, 2);
    }
}
