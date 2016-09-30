/**
 * Created by vershd on 9/28/2016.
 */
public class BinarySearch2 implements IBinarySearch {
    public int binarySearch(int[] inputArray, int searchFor) {

        int hi = inputArray.length - 1;
        int lo = 0;

        System.out.println('b');  //b toString is called
        System.out.println('b' + 'c');    //some int   + then toString
        System.out.println((char) ('a' + 4));   //e   converted t cahr
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (searchFor > inputArray[mid]) {
                lo = mid +1;
            }
            else if (searchFor < inputArray[mid]) {
                hi = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
