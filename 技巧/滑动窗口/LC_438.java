package 技巧.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class LC_438 {


//    438. 找到字符串中所有字母异位词

    public List<Integer> findAnagrams(String s, String p) {
        var ans = new ArrayList<Integer>();
        var cnt = new int[26];
        var tcnt = new int[26];
        for (var c : p.toCharArray()) tcnt[c - 'a']++;
        int i = 0, j = 0, len = s.length();
        while (i < len) {
            cnt[s.charAt(i) - 'a']++;
            if (i - j + 1 == p.length()) {
                if (ok(cnt, tcnt)) ans.add(j);
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
            i++;
        }
        return ans;
    }

    boolean ok(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
