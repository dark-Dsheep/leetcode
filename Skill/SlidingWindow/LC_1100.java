package Skill.SlidingWindow;

import java.util.HashMap;

public class LC_1100 {

    /*
        1100. 长度为 K 的无重复字符子串
     */
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int cnt = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {

            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() == k && r - l + 1 == 5) {
                cnt += 1;
                char c1 = s.charAt(l);
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) map.remove(c1);
                l++;
            }
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "havefunonleetcode";
        int k = 5;
        System.out.println(new LC_1100().numKLenSubstrNoRepeats(s, k));
    }
}
