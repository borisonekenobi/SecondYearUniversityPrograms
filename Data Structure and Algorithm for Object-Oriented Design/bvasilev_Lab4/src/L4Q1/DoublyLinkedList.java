package L4Q1;

import java.util.ArrayList;
public class DoublyLinkedList<E> {
    //---------------- nested Node class ----------------
    /**
     * Node of a doubly linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    public static class Node<E> {//Note: if you want to make this class private, you need to write the driver method inside this class
        /** The element stored at this node */
        private E element; // reference to the element stored at node
        /** A reference to the preceding node in the list */
        private Node<E> prev; // reference to the previous node in the list
        /** A reference to the subsequent node in the list */
        private Node<E> next; // reference to the subsequent node in the list
        /**
         * Creates a node with the given element and next node.
         *
         * @param element the element to be stored
         * @param prev reference to a node that should precede the new node
         * @param next reference to a node that should follow the new node
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
        // public accessor methods
        /**
         * Returns the element stored at the node.
         * @return the element stored at the node
         */
        public E getElement() { return element; }
        /**
         * Returns the node that precedes this one (or null if no such node).
         * @return the preceding node
         */
        public Node<E> getPrev() { return prev; }
        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() { return next; }
        // Update methods
        /**
         * Sets the node's previous reference to point to Node n.
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) { prev = p; }
        /**
         * Sets the node's next reference to point to Node n.
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------
    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header; // header sentinel
    /** Sentinel node at the end of the list */
    private Node<E> trailer; // trailer sentinel
    /** Number of elements in the list (not including sentinels) */
    private int size = 0; // number of elements in the list
    /** Constructs a new empty list. */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by
        header.setNext(trailer); // header is followed by trailer
    }
    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the linked list
     */
    public int size() { return size; }
    /**
     * Tests whether the linked list is empty.
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }
    /**
     * Adds an element to the end of the list.
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }
    // public update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor node just before the location where the new element is
    inserted
     * @param successor node just after the location where the new element is
    inserted
     */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    /**
     * Returns the first node which has a value equal to element or null if none is found.
     * @param element the value of the element variable in the node.
     * @return Node or null
     */
    public Node<E> findNode(E element) {
        if (header.getElement() == element) return header;
        Node<E> currNode = header;
        do {
            currNode = currNode.getNext();
            if (currNode.getElement() == element) return currNode;
        } while (currNode.getNext() != null);
        return null;
    }

    /**
     * Returns a String representation of the DoublyLinkedList
     * @return String
     */
    @Override
    public String toString() {
        ArrayList<E> arrayList = new ArrayList<>();
        if (header == null) return arrayList.toString();

        Node<E> currNode = header;
        arrayList.add(currNode.getElement());
        do {
            currNode = currNode.getNext();
            arrayList.add(currNode.getElement());
        } while (currNode.getNext() != null);
        return arrayList.toString();
    }
}