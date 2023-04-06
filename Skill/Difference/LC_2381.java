package Skill.Difference;

public class LC_2381 {
//    2381. 字母移位 II
static int mod = 26 * 10000;

    public String shiftingLetters(String s, int[][] shifts) {
        // 差分数组
        int n = s.length();
        var d = new int[n + 1];
        for (var sh : shifts) {
            // direction == 0表示字符向前移 -1, 1表示向后移动 +1
            int num = sh[2] == 0 ? -1 : 1;
            d[sh[0]] += num;
            d[sh[1] + 1] -= num; // +1 更新区间不用判断边界
        }
        // 前缀和还原数组
        for (int i = 1; i <= n; i++) d[i] += d[i - 1];
        var ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 负数取模
            int temp = 'a' + (s.charAt(i) - 'a' + d[i] + mod) % 26;
            ans.append((char) temp);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        var s = "abc";
        int[][] sh = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(new LC_2381().shiftingLetters(s, sh));
    }
}
