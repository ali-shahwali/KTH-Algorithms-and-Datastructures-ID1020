package Labb_4.HigherGrade;

import java.util.NoSuchElementException;
/*
README
    Priority queue where the smallest key has highest priority, uses a binary heap with array implementation.
    Used in higher grade assignment for dijkstra's shortest path algorithm.
*/
public class IndexMinPQ<Key extends Comparable<Key>>
{
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // pq contains corresponding vertice to its priority, index 1 has highest priority
    private int[] qp;        // inverse of pq, index 1 is the vertice that has the highest priority
    private Key[] keys;      // keys[i] = priority of i


    // constructor, sets every element inside qp to -1 used for checking if a spot is occupied or not
    public IndexMinPQ(int maxN)
    {
        if (maxN < 0)
            throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
        {
            qp[i] = -1;
        }
    }

    // if no elements in PQ, returns true
    public boolean isEmpty()
    {
        return n == 0;
    }

    // if qp at index i is not -1 we return true, i.e pq contains i
    public boolean contains(int i)
    {
        validateIndex(i);
        return qp[i] != -1;
    }

    // returns current size of pq
    public int size() {
        return n;
    }

    // insert a new element in to the pq, uses swim to maintain heap order
    public void insert(int i, Key key)
    {
        validateIndex(i);
        if (contains(i))
            throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    // deletes the element with the highest priority
    public int delMin()
    {
        if (n == 0)
            throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;
        keys[min] = null;
        pq[n+1] = -1;        // not needed
        return min;
    }

    // input a key with new value to decrease its key
    public void decreaseKey(int i, Key key)
    {
        validateIndex(i);
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) < 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the priority queue");
        keys[i] = key;
        swim(qp[i]);
    }

    // throw an IllegalArgumentException if i is an invalid index
    private void validateIndex(int i)
    {
        if (i < 0)
            throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN)
            throw new IllegalArgumentException("index >= capacity: " + i);
    }

    // compares and returns true if i > j
    private boolean greater(int i, int j)
    {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    // swaps places on 2 elements inside the priority queue, used when sinking and swimming
    private void exch(int i, int j)
    {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    // used to restore heap order upon insertion of new element
    private void swim(int k)
    {
        while (k > 1 && greater(k/2, k))
        {
            exch(k, k/2);
            k = k/2;
        }
    }

    // used to restore heap order upon deletion of smallest key (key with highest priority)
    private void sink(int k)
    {
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && greater(j, j+1))
                j++;
            if (!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

}
