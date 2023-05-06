package DataStructure.HashMap;

public class LC_1419 {

    /**
     * 1419. 数青蛙
     */

    static final char[] PRE = new char['s'];

    static {
        var cs = "croakc".toCharArray();
        for (int i = 1; i < cs.length; i++) {
            PRE[cs[i]] = cs[i-1];
        }
    }

    public int minNumberOfFrogs(String s) {
        var cnt = new int['s'];
        for (var ch : s.toCharArray()) {
            var pre = PRE[ch];
            if (cnt[pre] > 0) {     // 如果有青蛙发出 pre的声音
                cnt[pre]--;
            } else if (ch != 'c') { // 青蛙必须从 'c'开始叫
                return -1;
            }
            cnt[ch]++;
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0) {
            return -1;
        }
        return cnt['k'];
    }
}
