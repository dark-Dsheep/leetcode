package 技巧.前缀和;

import java.util.HashMap;

public class LC_1124 {

//    1124. 表现良好的最长时间段


    public int longestWPI(int[] hours) {
        int n = hours.length, ans = 0;
        int s = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) ans = i + 1; // 下标 0 到当前下标的这一段,满足条件
            else if (map.containsKey(s - 1)) {
                ans = Math.max(ans, i - map.get(s - 1)); // 中间存在某一段满足条件
            }
            map.putIfAbsent(s, i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
