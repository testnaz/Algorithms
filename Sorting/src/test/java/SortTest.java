import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    private ISort sort;

    @Test
    public void testInsertionSort() {
        sort = new InsertionSort();
        runTests(sort);
    }

    @Test
    public void testSelectionSort() {
        sort = new SelectionSort();
        runTests(sort);
    }

    @Test
    public void testShellSort() {
        sort = new ShellSort();
        runTests(sort);
    }

    private void runTests(ISort sort) {
        testSort(sort);
        testSortWithSameElements(sort);
        testSortWithNegatives(sort);
    }

    private void testSort(ISort sort) {
        Integer[] array = {3,2,1};
        sort.sort(array);
        System.out.println(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 3", new Integer(3), array[2]);
    }

    private void testSortWithSameElements(ISort sort) {
        Integer[] array = {3,2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be 1", new Integer(1), array[0]);
        Assert.assertEquals("Should be 2", new Integer(2), array[1]);
        Assert.assertEquals("Should be 2", new Integer(2), array[2]);
        Assert.assertEquals("Should be 3", new Integer(3), array[3]);
    }

    private void testSortWithNegatives(ISort sort) {
        Integer[] array = {3,-2,2,1};
        sort.sort(array);
        Assert.assertEquals("Should be -2", new Integer(-2), array[0]);
        Assert.assertEquals("Should be 1", new Integer(1), array[1]);
        Assert.assertEquals("Should be 2", new Integer(2), array[2]);
        Assert.assertEquals("Should be 3", new Integer(3), array[3]);
    }

}
