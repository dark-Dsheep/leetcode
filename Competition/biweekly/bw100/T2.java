package Competition.biweekly.bw100;

import java.util.TreeMap;

public class T2 {


    public int maximizeGreatness(int[] nums) {
        int res = 0;
        var tmap = new TreeMap<Long, Integer>();
        for (long x : nums) {
            tmap.put(x, tmap.getOrDefault(x, 0) + 1);
        }
        for (long x : nums) {
            var t = tmap.higherKey(x);
            if (t != null) {
                res++;
                tmap.put(t, tmap.get(t) - 1);
                if (tmap.get(t) == 0) tmap.remove(t);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
