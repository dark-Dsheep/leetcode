package 困难题训练;

public class LC_1340 {

//    1340. 跳跃游戏 V Rating(1866)


    Integer[] memo = new Integer[1001];
    int[] a;
    int D;

    public int maxJumps(int[] arr, int d) {
        a = arr;
        D = d;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    int dfs(int i) {
        if (memo[i] != null) return memo[i];
        int ans = 1;
        // i + x
        for (int x = 1; x <= D && i + x < a.length; x++) {
            if (a[i] <= a[i+x]) break;
            ans = Math.max(ans, 1 + dfs(i + x));
        }
        // i - x
        for (int x = 1; x <= D && i - x >= 0; x++) {
            if (a[i] <= a[i-x]) break;
            ans = Math.max(ans, 1 + dfs(i - x));
        }
        return memo[i] = ans;
    }

    public static void main(String[] args) {

    }


}
