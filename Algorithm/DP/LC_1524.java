package Algorithm.DP;

public class LC_1524 {

    private int mod = (int) 1e9 + 7;
    /*
        1524. 和为奇数的子数组数目
     */
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0;
        // dp[i][0] 表示以i结尾 和为奇数的子数组数目
        // dp[i][1] 表示以i结尾 和为偶数的子数组数目
        var dp = new int[n + 1][2];
        if (arr[0] % 2 != 0) {
            dp[0][0] = 1;
            res++;
        } else {
            dp[0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if(arr[i] % 2 !=0 ){ //当前元素是奇数
                dp[i][0] = dp[i - 1][1] + 1; // 奇数 + 偶数 = 奇数
                dp[i][1] = dp[i - 1][0];     // 奇数 + 奇数 = 偶数
            } else {              //当前元素是偶数
                dp[i][0] = dp[i - 1][0];     // 偶数 + 奇数 = 奇数
                dp[i][1] = dp[i - 1][1] + 1; // 偶数 + 偶数 = 偶数
            }
            res = (res + dp[i][0]) % mod;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
