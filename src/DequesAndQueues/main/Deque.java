import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mch on 9/14/14.
 */
public class Deque<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int dequeSize;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {
        first = null;
        last = null;
        dequeSize = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return dequeSize;
    }
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;

        if (oldFirst == null) {
            last = first;
        } else {
            oldFirst.previous = first;
        }

        dequeSize++;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        last.next = null;

        if (oldLast == null) {
            first = last;
        } else {
            oldLast.next = last;
        }

        dequeSize++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Node oldFirst = first;
        first = first.next;

        if (first == null) {
            last = null;
        } else {
            first.previous = null;
        }

        dequeSize--;
        return oldFirst.item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Node oldLast = last;
        last = last.previous;

        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }

        dequeSize--;
        return oldLast.item;

    }

    public Iterator<Item> iterator() {
        return new dequeIterator();
    }

    private class dequeIterator implements Iterator<Item> {
        Node pointer = first;

        public Item next() {
            if (pointer == null) throw new NoSuchElementException();
            Node oldPointer = pointer;
            pointer = pointer.next;
            return oldPointer.item;
        }

        public boolean hasNext() {
            return pointer != null;
        }

        public void remove() {
            //not supported
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {};
}
