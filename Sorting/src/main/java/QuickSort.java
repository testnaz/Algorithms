/**
 * NlogN time
 * Worst case  - (N+1)*N/2 when each time one of subarrays is empty
 * Has small auxiliary stack - i.e. need less extra memory (unlike MergeSort)
 * Works best when partition splits the array in even 2 halves
 */
public class QuickSort extends AbstractSort {
    public void sort(Comparable[] inputArray) {
        innerSort(inputArray, 0, inputArray.length-1);

    }

    private void innerSort(Comparable[] input, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int partitionIndex = partition(input, lo, hi);

        innerSort(input, lo, partitionIndex);
        innerSort(input, partitionIndex + 1, hi);
    }

    private int partition(Comparable[] input, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (input[++i].compareTo(input[lo]) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (input[--j].compareTo(input[lo]) >= 0) {
                if (j == lo) {
                    break;
                }
            }

            if (j <= i) {
                break;
            }

            exch(input, i, j);
        }

        exch(input, lo, j);
        return j;
    }
}
