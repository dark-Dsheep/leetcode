package DataStructure.HashMap;

import java.util.Arrays;

public class LC_1048 {

    /*
        1048. 最长字符串链
     */
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, ((o1, o2) -> o1.length()  - o2.length()));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() != 1) continue;
                if (check(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int x : dp) res = Math.max(res, x);
        return res;
    }

    // 检查字符串a 是不是 字符串b的前身
    private boolean check(String a, String b) {
        // len(a) + 1 = len(b)
        int i = 0, j = 0;
        int diff = 0;
        while (j < b.length()) {
            if (i >= a.length()) break;
            if (a.charAt(i) != b.charAt(j)) {
                diff += 1;
                j++;
                continue;
            }
            i++; j++;
        }
        if (j != b.length()) diff += b.length() - j;
        return diff == 1;
    }

    public static void main(String[] args) {
        String[] words = {"a","b", "ab", "bac"};
        System.out.println(new LC_1048().longestStrChain(words));
    }
}
