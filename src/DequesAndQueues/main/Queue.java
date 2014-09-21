/**
 * Created by mch on 9/14/14.
 */
public class Queue<Item> {
    private Node first;
    private Node last;

    public Queue() {
        first = null;
        last = null;
    }


    private class Node {
        public Item item;
        public Node next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item dequeue() {
        Node oldFirst = first;
        first = first.next;
        return oldFirst.item;
    }

    public boolean isEmpty() {
        return first == null;
    }





}
