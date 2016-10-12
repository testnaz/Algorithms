public abstract class AbstractSort implements ISort {

    protected void exch(Comparable[] inputArray, int i, int curMin) {
        Comparable curMinValue = inputArray[curMin];
        inputArray[curMin] = inputArray[i];
        inputArray[i] = curMinValue;
    }
}
