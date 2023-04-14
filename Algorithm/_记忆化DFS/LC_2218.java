package Algorithm._记忆化DFS;

import java.util.ArrayList;
import java.util.List;

public class LC_2218 {

//    2218. 从栈中取出 K 个硬币的最大面值和

    Integer[][] memo = new Integer[1010][2010];
    int[][] sum;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        sum = new int[n][];
        // 预处理一下piles sum[i][j]表示第i个栈的深度为j的得分
        for (int i = 0; i < n; i++) {
            int s = piles.get(i).size(), p = 0;
            sum[i] = new int[s+1];
            for (int j = 1; j <= s; j++) {
                p += piles.get(i).get(j-1);
                sum[i][j] = p;
            }
        }
        return dfs(0, k);
    }
    // 记忆化DFS
    // pos: 当前栈
    // k:   还剩几次可取
    int dfs(int pos, int k) {
        if (pos >= sum.length || k == 0) return 0;
        if (memo[pos][k] != null) return memo[pos][k];
        // 不取第pos个栈
        int ans = dfs(pos+1, k);
        // 取第pos个栈,枚举取的深度
        for (int i = 1; i <= Math.min(sum[pos].length-1, k); i++) {
            ans = Math.max(ans, sum[pos][i] + dfs(pos+1, k-i));
        }
        memo[pos][k] = ans;
        return ans;
    }

    public static void main(String[] args) {
        var piles = new ArrayList<List<Integer>>();
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(1,1,1,1,1,1,700));
        int k = 7;
        System.out.println(new LC_2218().maxValueOfCoins(piles, k));
    }
}
