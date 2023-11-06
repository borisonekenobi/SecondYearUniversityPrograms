package L4Q1;

public class Driver_DoublyLinkedList {
    /**
     * Driver method.
     * @param args an array of String type variables containing the configuration arguments given to the main method.
     */
    public static void main(String[] args) {
        myHeader(4, 1);

        DoublyLinkedList<MyStudent> borisList = new DoublyLinkedList<>();

        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.50);
        MyStudent s3 = new MyStudent("Vincent", 60.50);
        MyStudent s4 = new MyStudent("Hermione", 89.20);

        borisList.addLast(s0);
        borisList.addLast(s1);
        borisList.addLast(s2);
        borisList.addLast(s3);

        System.out.println(borisList.toString());

        DoublyLinkedList.Node<MyStudent> nodeS2 = borisList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> nodeS3 = borisList.findNode(s3);

        System.out.println("Adding Hermione to the list in between Luna and Vincent.....");
        borisList.addBetween(s4, nodeS2, nodeS3);

        System.out.println(borisList.toString());

        myFooter(4, 1);
    }

    /**
     * Used at the beginning of the code to show who wrote the code and the goal of the exercise.
     * @param labE_number Lab Exercise number
     * @param q_number Question number
     */
    public static void myHeader(int labE_number, int q_number) {
        System.out.printf("""
                =======================================================
                Lab Exercise %d-Q%d
                Prepared By: Boris Vasilev
                Student Number: 251276924
                Goal of this Exercise: To demo doubly linked lists
                =======================================================
                """, labE_number, q_number);
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
