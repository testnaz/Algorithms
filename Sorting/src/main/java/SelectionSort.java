/**
 * N^2/2 array accesses
 * N comparisons
 * Overall N^2 performance
 */
public class SelectionSort extends AbstractSort {

    public void sort(Comparable[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            int curMin = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j].compareTo(inputArray[curMin]) < 0) {
                    curMin = j;
                }
            }

            exch(inputArray, i, curMin);
        }
    }
}
