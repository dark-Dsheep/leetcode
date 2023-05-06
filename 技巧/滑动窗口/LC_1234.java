package 技巧.滑动窗口;

public class LC_1234 {
//    1234. 替换子串得到平衡字符串

    public int balancedString(String S) {
        int n = S.length();
        var s = S.toCharArray();
        var count = new int['X'];
        int l = 0, r = 0, m = n / 4;
        for (var c : s) count[c]++;
        // s已经是平衡字符串
        if (count['Q'] == m && count['W'] == m && count['E'] == m && count['R'] == m) {
            return 0;
        }
        // 枚举 r
        int ans = n;
        while (r < n) {
            --count[s[r]];
            while (vaildCnts(count, m)) {
                ans = Math.min(ans, r - l + 1);
                ++count[s[l]];
                l++;
            }
            r++;
        }
        return ans;
    }

    // 判断待替换子串之外的任意字符的出现次数是否都不超过 m
    boolean vaildCnts(int[] count, int m) {
        return count['Q'] <= m && count['W'] <= m && count['E'] <= m && count['R'] <= m;
    }

    public static void main(String[] args) {

        System.out.println(new LC_1234().balancedString("W W E Q E R Q W Q W W R W W E R Q W E Q"));
    }
}
