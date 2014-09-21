import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mch on 9/14/14.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int N;


    public RandomizedQueue() {
        q = (Item[]) new Object[1];
        N = 0;
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public int size() {
        return N;
    }


    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (N == 0) resize(1);
        if (N == q.length) resize(2*q.length);
        q[N++] = item;
    }


    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomLocation = StdRandom.uniform(0, N);
        Item randomItem = q[randomLocation];
        N--;

        //shiftLeft(randomLocation);
        q[randomLocation] = q[N];
        q[N] = null;
        if (N <= q.length / 4) resize(q.length / 2);


        return randomItem;
    }

    /*
    No longer needed

    private void shiftLeft(int location) {
        for (int i = location; i < N; i++) {
            if (i < N) q[i] = q[i+1];
        }
        q[N] = null;

    }
    */

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return q[StdRandom.uniform(0,N)];
    }

    private void resize(int newSize) {
        Item[] newQ = (Item[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            newQ[i] = q[i];
        }
        q = newQ;
    }

    public static void main(String[] args) {
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Item[] arr;
        private int n;
        private int current;

        public QueueIterator() {
            n = N;
            arr = (Item[]) new Object[n];

            for (int i = 0; i < n; i++) {
                arr[i] = q[i];
            }

            StdRandom.shuffle(arr);

            current = 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arr[current++];
        }

        public boolean hasNext() {
            return current < n;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}



