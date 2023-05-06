package 技巧.滑动窗口;

import java.util.HashMap;

public class LC_1297 {

    /*
        1297. 子串的最大出现次数
     */

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int cnt = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 重点: 只需统计最短的子串
            // abc 会覆盖a, ab 长的一定会覆盖短的, 只考虑最短
            while (i - j + 1 > minSize || map.size() > maxLetters) {
                char cc = s.charAt(j);
                map.put(cc, map.get(cc) - 1);
                if (map.get(cc) == 0) map.remove(cc);
                j++;
            }
            // 更新最大出现次数
            if (i - j + 1 == minSize) {
                String str = s.substring(j, i + 1);
                // System.out.println("str =>" + str);
                count.put(str, count.getOrDefault(str, 0) + 1);
                cnt = Math.max(cnt, count.get(str));
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "aabcabcab";
        int maxLetters = 2;
        int minSize = 2;
        int maxSize = 3;
        System.out.println(new LC_1297().maxFreq(s, maxLetters, minSize, maxSize));
    }
}
