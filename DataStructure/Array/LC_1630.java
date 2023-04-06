package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1630 {

    /*
        1630. 等差子数组
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            if (check(arr)) {
                res.add(true);
            }  else {
                res.add(false);
            }
        }
        return res;
    }

    private boolean check(int[] arr) {
        if (arr.length < 3) return true;
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        {-3,-6,-8,-4,-2,-8,-6,0,0,0,0}
//        {5,4,3,2,4,7,6,1,7}
//        {6,5,6,3,7,10,7,4,10}
        int[] nums =  {-3,-6,-8,-4,-2,-8,-6,0,0,0,0};
        int[] l = {5,4,3,2,4,7,6,1,7};
        int[] r = {6,5,6,3,7,10,7,4,10};
        System.out.println(new LC_1630().checkArithmeticSubarrays(nums, l, r));
    }
}
