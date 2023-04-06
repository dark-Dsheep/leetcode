package DataStructure.Array;

import java.util.Arrays;

public class LC_1846 {

    /*
        1846. 减小和重新排列数组后的最大元素
     */

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                // 减小arr[i]
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {

    }
}
