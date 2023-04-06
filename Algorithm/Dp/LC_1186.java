package Algorithm.Dp;

public class LC_1186 {

//    1186. 删除一次得到子数组最大和

    public int maximumSum(int[] arr) {
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        // dp[i][0] 表示不使用权力(删除)得到的子数组最大和
        // dp[i][1] 表示使用权力(删除)得到的子数组最大和
        var dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int ans = -0x3f3f3f;
        for (int i = 1; i < n; i++) {
            // 当前不使用权力 = Max(上一个使用权力, 上一个没使用权力)
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            // 当前使用权力   = Max(上一个没使用权力, 上一个使用了权力)
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
            // System.out.println("ans -> " + ans);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
