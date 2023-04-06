package Algorithm.MemoSearch;

public class LC_2400 {

    private int mod = (int) 1e9 + 7;
    private Integer[][] memo = new Integer[3000][3000];
    // private HashMap<String, Integer> memo = new HashMap<>();


    /*
         2400. 恰好移动 k 步到达某一位置的方法数
     */
    public int numberOfWays(int startPos, int endPos, int k) {
        return dfs(startPos, k, endPos);
    }

    private int dfs(int cur, int k, int endPos) {
        if (cur == endPos && k == 0) {  // 一种合法的解
            return 1;
        }
        if (cur != endPos && k == 0) {  // 移动次数用完 还没到endPos
            return 0;
        }
        // var key = cur + "_" + k;
        // if (memo.containsKey(key)) {
        //     return memo.get(key);
        // }
        if (memo[cur + 1000][k] != null) {
            return memo[cur + 1000][k];
        }
        int res = 0;

        res = (res + dfs(cur + 1, k - 1, endPos)) % mod; // 向右
        res = (res + dfs(cur - 1, k - 1, endPos)) % mod; // 向左

        // memo.put(key, res);
        memo[cur + 1000][k] = res; // 记忆化
        return res;
    }

    public static void main(String[] args) {

        System.out.println(15 / 3);
    }
}
