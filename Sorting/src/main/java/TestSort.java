
public class TestSort extends AbstractSort {

    public void sort(Comparable[] inputArray) {
        int size = inputArray.length;

        for (int k = size / 2; k >= 0; k--) {
            heapify_sink(inputArray, k, size);
        }

        while (size > 0) {
            exch(inputArray, 0, --size);
            heapify_sink(inputArray, 0, size);
        }
    }


    private void heapify_sink(Comparable[] input, int elem_num, int size_limit) {
        while (2 * elem_num + 1 < size_limit) {
            int j = 2 * elem_num + 1;
            if (j + 1 < size_limit && input[j].compareTo(input[j + 1]) < 0) j++;
            if (!(input[elem_num].compareTo(input[j]) < 0)) break;
            exch(input, elem_num, j);
            elem_num = j;
        }
    }
}
