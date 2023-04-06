package Competition.biweekly.bw101;

import java.util.Arrays;
import java.util.HashMap;

public class T2 {


    public int maximumCostSubstring(String s, String cs, int[] vals) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < cs.length(); i++) {
            map.put(cs.charAt(i), vals[i]);
        }
        int n = s.length();
        s = " " + s;
        var dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            var c = s.charAt(i);
            int v = c - 'a' + 1;
            if (map.containsKey(c)) {
                dp[i] = Math.max(dp[i-1] + map.get(c), map.get(c));
            } else {
                dp[i] = Math.max(dp[i-1] + v, v);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    public static void main(String[] args) {

    }
}
