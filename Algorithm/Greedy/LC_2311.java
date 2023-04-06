package Algorithm.Greedy;

public class LC_2311 {


    //    2311. 小于等于 K 的最长二进制子序列

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int m = Integer.toBinaryString(k).length();
        if (n < m) return n;
        int ans = m-1;
        if (Integer.parseInt(s.substring(n-m), 2) <= k) {
            ans = m;
        }
        for (int i = 0; i < n-m; i++) {
            // 前导零不影响答案 前面有多少零就填多少零
            if (s.charAt(i) == '0') ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
