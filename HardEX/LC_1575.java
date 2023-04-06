package HardEX;

public class LC_1575 {


//    1575. 统计所有可行路径 Rating(1575)
    int mod = 1000000007;
    Integer[][] f = new Integer[110][210];
    int[] loc;
    int ed;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        loc = locations;
        ed = finish;
        return dfs(start, fuel);
    }

    int dfs(int pos, int tot) {
        if (tot < 0) return 0;
        if (f[pos][tot] != null) return f[pos][tot];
        // 这里需要继续dfs，因为每个城市可以经过任意次，下面可能还存在到ed的方案
        int ans = pos == ed ? 1 : 0;
        for (int i = 0; i < loc.length; i++) {
            if (i == pos) continue;
            ans += dfs(i, tot-Math.abs(loc[pos] - loc[i]));
            ans %= mod;
        }
        return f[pos][tot] = ans;
    }

    public static void main(String[] args) {
        int[] loc = {2, 3, 6, 8, 4};

    }
}
