package Algorithm.DP;

public class LC_121 {

//    121. 买卖股票的最佳时机

    public int maxProfit(int[] prices) {

        int ans = 0;
        int min = 0x3f3f3f;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
