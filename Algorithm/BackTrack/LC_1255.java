package Algorithm.BackTrack;

public class LC_1255 {
    String[] ww; int[] s;
    int[] cnt = new int[26]; // 记录letters中字符的个数
    int ans;

//    1255. 得分最高的单词集合
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        ww = words;
        s = score;
        for (var c : letters) cnt[c-'a']++;
        dfs(0, 0);
        return ans;
    }

    void dfs(int i, int sum) {
        if (i >= ww.length) {
            ans = Math.max(ans, sum);
            return;
        }
        // 选择words[i]
        var w = ww[i];
        var ok = true;
        for (var c : w.toCharArray()) {
            if (cnt[c-'a'] == 0) ok = false;  // 字符不够
            cnt[c-'a']--;
            sum += s[c-'a'];               // 累加得分
        }
        if (ok) dfs(i + 1, sum);
        // 恢复现场
        for (var c : w.toCharArray()) {
            cnt[c-'a']++;
            sum -= s[c-'a'];
        }
        // 不选words[i]
        dfs(i + 1, sum);
    }

    public static void main(String[] args) {

    }
}
