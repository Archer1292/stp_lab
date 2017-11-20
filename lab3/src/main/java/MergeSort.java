import java.util.Arrays;

/**
 * Class to sort an array of integer type by a merge
 *
 * @author      Bratus Nadia <archer1292 @ gmail.com>
 * @version     1.0
 * @since       2017-10-20
 */
public class MergeSort implements Sorter {

    /**
     * This is the method which sorts the array by a merge.
     * The method recursively calls itself until the input array is parsed into single arrays, then a merge occurs
     * @param arr is integer array.
     * @return Nothing.
     * @exception NullPointerException
     * @see NullPointerException
     */

    public int[] sort(int[] arr) throws NullPointerException{
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sort(Arrays.copyOfRange(arr, 0, middle)),
                sort(Arrays.copyOfRange(arr, middle, len)));
    }

    /**
     * This is the method which sorts the array by a merge.
     * The method recursively calls itself until the input array is parsed into single arrays, then a merge occurs
     * @param arr1 is integer array.
     * @param arr2 is integer array.
     * @return int array.
     * @exception NullPointerException
     * @see NullPointerException
     */
    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int a = 0, b = 0, len = len1 + len2; // a, b - счетчики в массивах
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (arr1[a] > arr2[b]) result[i] = arr2[b++];
                else result[i] = arr1[a++];
            } else if (b < len2) {
                result[i] = arr2[b++];
            } else {
                result[i] = arr1[a++];
            }
        }
        return result;
    }
}