package Competition.biweekly.bw86;

import java.util.HashSet;

public class T1 {

    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && j-i+1 == 2; j++) {
                int v = nums[i] + nums[j];
                if (set.contains(v)) return true;
                set.add(v);
            }
        }
        return false;
    }
}
