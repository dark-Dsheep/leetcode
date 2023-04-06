package HardEX;

public class LC_1416 {


//    1416. 恢复数组 Rating(1920)

    int mod = 1000000007;
    String s;
    int k;
    Integer[] memo = new Integer[100001];

    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        return dfs(0);
    }

    int dfs(int pos) {
        if (pos >= s.length()) return 1;
        if (memo[pos] != null) return memo[pos];
        int ans = 0;
        long sum = 0;
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(pos) == '0') break; // 前导零
//            long v = Long.parseLong(s.substring(pos, i+1));
//            if (v > k) break;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum > k) break;

            ans += dfs(i+1);
            ans %= mod;
        }
        return memo[pos] = ans;
    }

    public static void main(String[] args) {
        String s = "2020";
        int k = 30;
        System.out.println(new LC_1416().numberOfArrays(s, k));
    }
}
