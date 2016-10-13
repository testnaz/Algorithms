/**
 * Sort w/o recursion
 */
public class BottomUpMergeSort extends AbstractSort {

    public void sort(Comparable[] inputArray) {
        int n = inputArray.length;
        Comparable[] aux = new Comparable[n];
        //Set up width of a sub-array we are going to sort
        //And double it - i.e. sort small sub-arrays of 2 elements, than 4, than 8...
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len * 2 - 1, n - 1);
                for (int k = 0; k < inputArray.length; k++) {
                    aux[k] = inputArray[k];
                }
                merge(inputArray, aux, lo, mid, hi);
            }
        }
    }

    private void merge(Comparable[] a, Comparable[] temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            } else if (j > hi) {
                a[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) < 0) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }

}
