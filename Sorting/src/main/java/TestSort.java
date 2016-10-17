
public class TestSort extends AbstractSort{

    private int CUTOFF = 3;

    public void sort(Comparable[] input) {
        Comparable[] temp = new Comparable[input.length];


        int n = input.length;

        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len+len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len*2 -1, n - 1);

                for (int k = 0; k < input.length; k++) {
                    temp[k] = input[k];
                }
                merge(input, temp, lo, mid, hi);
            }
        }
    }

    private void merge(Comparable[] input, Comparable[] temp, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                input[k] = temp[j++];
            }
            else if (j > hi) {
                input[k] = temp[i++];
            }
            else if (temp[i].compareTo(temp[j]) < 0) {
                input[k] = temp[i++];
            }
            else {
                input[k] = temp[j++];
            }
        }
    }
}
