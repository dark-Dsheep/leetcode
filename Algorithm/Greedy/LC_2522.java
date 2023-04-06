package Algorithm.Greedy;

public class LC_2522 {

    /*
        2522. 将字符串分割成值不超过 K 的子字符串
     */
    public int minimumPartition(String s, int k) {
        long x = 0;
        int ans = 0;
        // 贪心思路: 前面的字符分割越多越好
        for (char c : s.toCharArray()) {
            int val = c - '0';
            if (val > k) return -1;
            x = x * 10 + val;
            if (x > k) {
                ans += 1;
                x = val;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        String s = "165462";
        int k = 60;
        System.out.println(new LC_2522().minimumPartition(s, k));
    }
}
