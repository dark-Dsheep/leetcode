package DataStructure.Array;

public class LC_2110 {


    /*
        2110. 股票平滑下跌阶段的数目
     */

    // 滑动窗口
    public long getDescentPeriods(int[] prices) {
        int l = 0, r = 0;
        long res = 0;
        while (r < prices.length) {
            if (l == r) {
                res += 1;
                r++;
                continue;
            }
            if (prices[r] - prices[r - 1] == -1) {
                res += r - l + 1;
                r++;
            } else {
                l = r;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        System.out.println(new LC_2110().getDescentPeriods(prices));
    }
}
