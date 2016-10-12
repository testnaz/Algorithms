/**
 * Depends on input
 * If already sorted - linear time (N-1)
 * If Completely unsorted - N^2 time (N^2/4 compares and N^2/4 exchanges - so slower than SelectionSort)
 */
public class InsertionSort extends AbstractSort {
    public void sort(Comparable[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j > 0 && inputArray[j].compareTo(inputArray[j-1]) < 0; j--) {
                exch(inputArray, j, j-1);
            }
        }
    }
}
