package 技巧.前缀和;

import java.util.HashMap;

public class LC_1371 {

//    1371. 每个元音包含偶数次的最长子字符串 TODO

    public int findTheLongestSubstring(String s) {
        var ss = s.toCharArray();
        int ans = 0, sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < ss.length; i++) {
            sum += check(ss[i]) ? 1 : 0;
            if (sum % 2 == 0 && map.containsKey(sum)) {

            } else {

            }
        }
        return ans;
    }

    boolean check(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    public static void main(String[] args) {

    }
}
