package 困难题训练;

import java.util.HashMap;

public class LC_1553 {

//    1553. 吃掉 N 个橘子的最少天数 Rating(2048)


    HashMap<Integer, Integer> f = new HashMap<>();
    public int minDays(int n) {
        return dfs(n);
    }

    int dfs(int n) {
        if (n < 3) return n;
        if (f.containsKey(n)) return f.get(n);
        int x = n % 2; // 从第n天吃到2的倍数所需要的天数
        int y = n % 3; // 从第n天吃到3的倍数所需要的天数
        int ans = Math.min(x+dfs(n/2)+1, y+dfs(n/3)+1);
        f.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new LC_1553().minDays(n));
    }
}
