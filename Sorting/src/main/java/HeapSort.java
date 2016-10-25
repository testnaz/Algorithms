/**
 * NlogN guaranteed time
 * N extra space
 */
public class HeapSort extends AbstractSort {
    public void sort(Comparable[] inputArray) {
        int n = inputArray.length;


        for (int k = n / 2; k >= 0; k--)
            sink(inputArray, k, n);
        while (n > 0) {
            exch(inputArray, 0, --n);
            sink(inputArray, 0, n);
        }
    }

    /**
     * Sink element down the binary tree to maintain the condition that tree is heap ordered (children < parent)
     * @param pq
     * @param k
     * @param n
     */
    private void sink(Comparable[] pq, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && (pq[j].compareTo(pq[j + 1]) < 0)) j++;
            if (!(pq[k].compareTo(pq[j]) < 0)) break;
            exch(pq, k, j);
            k = j;
        }
    }
}
