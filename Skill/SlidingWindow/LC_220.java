package Skill.SlidingWindow;

import java.util.TreeMap;
import java.util.TreeSet;

public class LC_220 {


    /*
        220. 存在重复元素
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            tmap.put(nums[r], tmap.getOrDefault(nums[r], 0) + 1);
            if (Math.abs(r - l) >= k) {
                int v = nums[l];
                tmap.put(v, tmap.get(v) - 1);
                if (tmap.get(v) == 0) tmap.remove(v);
                Integer ge = tmap.ceilingKey(v);
                Integer le = tmap.floorKey(v);
                if (ge != null && Math.abs(v - ge) <= t) return true;
                if (le != null && Math.abs(v - le) <= t) return true;
                l++;
            }
            r++;
        }
        while (l < r && Math.abs(l - r) <= k) {
            int v = nums[l];
            tmap.put(v, tmap.get(v) - 1);
            if (tmap.get(v) == 0) tmap.remove(v);
            Integer ge = tmap.ceilingKey(v);
            Integer le = tmap.floorKey(v);
            if (ge != null && Math.abs(v - ge) <= t) return true;
            if (le != null && Math.abs(v - le) <= t) return true;
            l++;
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> tset = new TreeSet<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            long v = nums[r] * 1L;
            // 找到第个大于等于v 小于等于v的数
            Long ge = tset.ceiling(v);
            Long le = tset.floor(v);
            if (ge != null && Math.abs(v - ge) <= t) return true;
            if (le != null && Math.abs(v - le) <= t) return true;
            tset.add(v);
            if (r >= k) tset.remove(nums[r - l] * 1L);
            r++;
            l++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3, t = 0;
        System.out.println(new LC_220().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
