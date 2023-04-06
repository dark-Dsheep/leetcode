package Competition.weekly.wr333;

import java.util.ArrayList;

public class T1 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        var list = new ArrayList<int[]>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            var a = nums1[i][0];
            var b = nums2[j][0];
            if (a < b) {
                list.add(new int[]{a, nums1[i][1]});
                i++;
            } else if (a > b) {
                list.add(new int[]{b, nums2[j][1]});
                j++;
            } else {
                list.add(new int[]{a, nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }
        while (i < nums1.length) { list.add(new int[]{nums1[i][0], nums1[i][1]}); i++; }
        while (j < nums2.length) { list.add(new int[]{nums2[j][0], nums2[j][1]}); j++; }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {

    }
}
