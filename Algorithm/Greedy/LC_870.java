package Algorithm.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class LC_870 {


    /*
        870. 优势洗牌
     */
    public int[] advantageCount(int[] A, int[] B) {
        // 贪心思路
        // 每次从nums1中找 大于nums2[i]的最小值
        // 如果没有 拿nums1中的最小值来填充
        int n = A.length;
        TreeSet<Integer> tset = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : A) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) tset.add(x);
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            Integer higher = tset.higher(B[i]);
            if (higher == null) higher = tset.first();
            ret[i] = higher;
            map.put(higher, map.get(higher) - 1);
            if (map.get(higher) == 0) tset.remove(higher);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums1 =  {2, 0, 4, 1, 2};
        int[] nums2 = {1, 3, 0, 0, 2};
        System.out.println(Arrays.toString(new LC_870().advantageCount(nums1, nums2)));
    }
}
