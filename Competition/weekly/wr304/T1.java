package Competition.weekly.wr304;

import java.util.HashSet;

public class T1 {

    public int minimumOperations(int[] nums) {
        var set = new HashSet<Integer>();
        for (int x : nums) {
            if (x != 0) set.add(x);
        }
        return set.size();
    }

}
