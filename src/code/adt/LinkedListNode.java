package code.adt;

public class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    int value;

    LinkedListNode(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}
