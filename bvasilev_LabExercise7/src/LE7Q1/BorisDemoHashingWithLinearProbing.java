package LE7Q1;

import java.util.Arrays;
import java.util.Scanner;

public class BorisDemoHashingWithLinearProbing {
    /**
     * int value representing an available space in the hash table
     */
    public static final int AVAILABLE = -111;

    public static int items; // An int type field that will hold the value of the total number of data items to be added to the hash table.
    public static Scanner input = new Scanner(System.in); // A Scanner type object reference.
    public static double lf; // double type field to record the load-factor.
    public static int tableCapacity; // Will store the value of the table capacity.
    public static BorisValueEntry[] hashTable; // A BorisValueEntry type array reference.
    public static BorisValueEntry[] workingHashTable; // A second BorisValueEntry type array reference, which will be used to store the copy of the hashTable reference for rehashing operation

    /**
     * Adds the given key to the hash table using linear probing
     *
     * @param key Integer representation of the key
     */
    public static void addValueLinearProbe(Integer key) {
        int len = hashTable.length;
        int hash = key.hashCode();
        int index = hash % len;
        if (index < 0) index += len;

        int firstAvailable = -1;
        while (hashTable[index].getKey() != null) {
            if (hashTable[index].getKey() == AVAILABLE && firstAvailable == -1) firstAvailable = index;
            ++index;
            if (index >= len) index = 0;
        }

        hashTable[firstAvailable == -1 ? index : firstAvailable] = new BorisValueEntry(key);
    }

    /**
     * Gets the smallest prime number greater than or equal to the given int
     *
     * @param n int number that is being checked for prime-ness
     * @return an int number representing the calculated prime number
     */
    public static int checkPrime(int n) {
        int m = n / 2;
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2;
                n++;
                m = n / 2;
            }
        }
        return n;
    }

    /**
     * Removes the given key from the hash table using linear probing
     *
     * @param key Integer representation of the key
     */
    public static void removeValueLinearProbe(Integer key) {
        int len = hashTable.length;
        int hash = key.hashCode();
        int index = hash % len;
        if (index < 0) index += len;

        while (hashTable[index].getKey() != null) {
            if (hashTable[index].getKey().equals(key)) {
                hashTable[index].setKey(AVAILABLE);
                System.out.printf("%d is Found! ", key);
                printHashTable();
                return;
            }
            ++index;
            if (index >= len) index = 0;
        }

        System.out.printf("%d is not found! ", key);
        printHashTable();
    }

    /**
     * Prints the hash table replacing any instance of -111 with available
     */
    public static void printHashTable() {
        System.out.print("The Current Hash-Table: [");
        boolean firstElement = true;
        for (BorisValueEntry valueEntry : hashTable) {
            String key;
            if (valueEntry.getKey() == null) key = null;
            else if (valueEntry.getKey() == AVAILABLE) key = "available";
            else key = valueEntry.getKey().toString();
            if (!firstElement) System.out.print(", ");
            System.out.print(key);
            firstElement = false;
        }
        System.out.println("]");
    }

    /**
     * Expands the size of the hash table
     */
    public static void rehashingWithLinearProbe() {
        workingHashTable = new BorisValueEntry[hashTable.length];
        System.arraycopy(hashTable, 0, workingHashTable, 0, hashTable.length);

        int newArrSize = checkPrime(2 * hashTable.length);
        hashTable = new BorisValueEntry[newArrSize];
        Arrays.fill(hashTable, new BorisValueEntry());

        for (BorisValueEntry value : workingHashTable) {
            if (value.getKey() == null || value.getKey() == AVAILABLE) continue;
            addValueLinearProbe(value.getKey());
        }
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
                Goal of this Exercise: To demo my understanding of hashing with open addressing collision resolving techniques.
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
     * The driver method
     *
     * @param args Arguments passed when running the program (ignored in this case)
     */
    public static void main(String[] args) {
        myHeader(7, 1);

        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.print("How many data items: ");
        items = Integer.parseInt(input.nextLine());
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = Double.parseDouble(input.nextLine());
        tableCapacity = checkPrime((int) Math.ceil(items / lf));
        hashTable = new BorisValueEntry[tableCapacity];
        Arrays.fill(hashTable, new BorisValueEntry());
        System.out.printf("The minimum required table capacity would be: %d\n", hashTable.length);
        for (int i = 0; i < items; i++) {
            System.out.printf("Enter item %d: ", i + 1);
            addValueLinearProbe(Integer.parseInt(input.nextLine()));
        }
        printHashTable();
        System.out.println();

        System.out.println("Let’s remove two values from the table and then add one.......\n");

        System.out.print("Enter a value you want to remove: ");
        removeValueLinearProbe(Integer.parseInt(input.nextLine()));
        System.out.print("Enter a value you want to remove: ");
        removeValueLinearProbe(Integer.parseInt(input.nextLine()));
        System.out.print("Enter a value you want to add to the table: ");
        addValueLinearProbe(Integer.parseInt(input.nextLine()));
        printHashTable();
        System.out.println();

        System.out.println("Rehashing the table...");
        rehashingWithLinearProbe();
        System.out.printf("The rehashed table capacity is: %d\n", hashTable.length);
        printHashTable();

        myFooter(7, 1);
    }
}
