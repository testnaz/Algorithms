
public class ShellSort extends AbstractSort {
    public void sort(Comparable[] inputArray) {
        int N = inputArray.length;
        int h = 1;

        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && inputArray[j].compareTo(inputArray[j - h]) < 0; j -= h) {
                    exch(inputArray, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
