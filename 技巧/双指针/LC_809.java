package 技巧.双指针;

public class LC_809 {


    /*
        809. 情感丰富的文字
     */

    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (var w : words) {
            if (check(s, w)) res++;
        }
        return res;
    }

    private boolean check(String ss, String ww) {
        int p1 = 0, p2 = 0;
        while (p1 < ss.length() && p2 < ww.length()) {
            int sCnt = 0, wCnt = 0;
            var c = ss.charAt(p1);
            while (p1 < ss.length() && ss.charAt(p1) == c) {
                p1++;
                sCnt++;
            }
            while (p2 < ww.length() && ww.charAt(p2) == c) {
                p2++;
                wCnt++;
            }
            // 单词word中的c字符数量 比 s中的c字符数量多
            if (wCnt > sCnt) return false;
            // 单词s中的c字符数量 比word的c字符数量多,但是不多出3个
            // w无法扩张的得到s
            if (sCnt > wCnt && sCnt < 3) return false;
        }
        return p1 == ss.length() && p2 == ww.length();
    }


    public static void main(String[] args) {
        var s = "heeellooo";
        String[] words = {"hello","hi","helo"};
        System.out.println(new LC_809().expressiveWords(s, words));
    }
}
