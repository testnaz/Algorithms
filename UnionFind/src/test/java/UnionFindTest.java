import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UnionFindTest {

    private int N = 10;
    private List<String> data = new ArrayList<String>();

    private IUnionFind unionFind;

    public void loadData(String fileName) throws IOException {
        //Load data
        BufferedReader in = new BufferedReader(new InputStreamReader(UnionFindTest.class.getResourceAsStream(fileName)));
        N = Integer.valueOf(in.readLine());
        unionFind = new QuickFind(N);
        String nextLine;
        while ((nextLine = in.readLine()) != null) {
            String[] strData = nextLine.split(" ");
            unionFind.union(Integer.valueOf(strData[0]), Integer.valueOf(strData[1]));
            data.add(nextLine);
        }
    }
    @Before
    public void before() {
        unionFind = new WeightedQuickUnion(N);
    }


    @Test
    public void testSmallData() throws IOException {
        loadData("smallData");
        Assert.assertTrue(unionFind.isConnected(0,5));
        Assert.assertTrue(unionFind.find(5) == unionFind.find(0));

    }

    @Test
    public void testUnionOf2Elements() {
        unionFind.union(0,9);
        Assert.assertTrue("Elements are not connected!", unionFind.isConnected(0,9));
        Assert.assertFalse("Elements should not be connected!", unionFind.isConnected(0,8));
    }

    @Test
    public void testUnionOfAllElementsWithFirst() {
        for (int i = 0; i < N; i++) {
            unionFind.union(0, i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertTrue("Elements are not connected:" + i, unionFind.isConnected(0,i));
        }
    }

    @Test
    public void testUnionOfAllElements() {
        for (int i = 1; i < N; i++) {
            unionFind.union(i-1, i);
        }

        for (int i = 0; i < N; i++) {
            Assert.assertTrue("Elements are not connected!", unionFind.isConnected(0,i));
        }
    }

    @Test
    public void testCombine2Sets() {
        unionFind.union(0,1);
        unionFind.union(1,2);
        unionFind.union(2,3);

        unionFind.union(5,6);
        unionFind.union(7,6);
        unionFind.union(7,8);

        unionFind.union(0,8);

        Assert.assertTrue(unionFind.isConnected(0, 8));
        Assert.assertTrue(unionFind.isConnected(2, 5));
        Assert.assertTrue(unionFind.isConnected(1, 7));
        Assert.assertTrue(unionFind.isConnected(7, 3));
    }
}
