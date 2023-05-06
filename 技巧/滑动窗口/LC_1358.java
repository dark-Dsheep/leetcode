package 技巧.滑动窗口;

import java.util.HashMap;

public class LC_1358 {

    /*
        1358. 包含所有三种字符的子字符串数目
     */
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int i = 0, j = 0;
        // 当三种字符都出现过 窗口往后扩展一定满足条件 -> 缩小窗口
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() == 3) {
                // 重点 s.length() - i 表示以当前窗口为前缀子串的数量
                cnt += s.length() - i;
                char cc = s.charAt(j);
                map.put(cc, map.get(cc) - 1);
                if (map.get(cc) == 0) map.remove(cc);
                j++;
            }
            i++;
        }
        return cnt;
    }

    public int numberOfSubstrings2(String s) {
        // 恰好三种字符的子串数目 = 最多包含三种的子字符串数目 - 最多包含二种子字符串的数目
        // 恰好k种字符的子串数目 = 最多包含k种字符的子串数目 - 最多包含k-1种字符的子串的数目
        return getSub(s, 3) - getSub(s, 2);
    }

    private int getSub(String s, int k) {
        int l = 0, r = 0, m = 0;
        int res = 0;
        int[] map = new int[3];
        while (r < s.length()) {
            char c = s.charAt(r);
            map[c - 'a']++;
            if (map[c - 'a'] == 1) m++;
            while (m > k) {
                char cc = s.charAt(l);
                map[cc - 'a']--;
                if (map[cc - 'a'] == 0) m--;
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new LC_1358().numberOfSubstrings2(s));
    }
}
