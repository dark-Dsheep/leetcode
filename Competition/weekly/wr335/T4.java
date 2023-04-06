package Competition.weekly.wr335;

public class T4 {

    static int mod = (int) 1e9 + 7;
    Integer[][][] memo = new Integer[51][51][1010];
    int[][] t;

    public int waysToReachTarget(int target, int[][] types) {
        t = types;
        return dfs(0, target) % mod;
    }

    int dfs(int i, int target) {
        if (target == 0) return 1;
        if (i >= t.length || target < 0) return 0;
        int cnt = t[i][0];
        if (memo[i][cnt][target] != null) {
            return memo[i][cnt][target];
        }
        int ans = 0;
        if (t[i][0] < 1) {
            ans = (ans + dfs(i + 1, target) % mod);
        } else {
            t[i][0]--;
            ans = (ans + dfs(i, target - t[i][1]) % mod);
            t[i][0]++;
            ans = (ans + dfs(i + 1, target) % mod);
        }
        memo[i][cnt][target] = ans;
        return ans;
    }
    public static void main(String[] args) {
        int target = 18;
        int[][] t = {{6, 1}, {3, 2}, {2, 3}};
        System.out.println(new T4().waysToReachTarget(target, t));
    }
}
