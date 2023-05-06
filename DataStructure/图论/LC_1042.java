package DataStructure.图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1042 {
//    1042. 不邻接植花

    static int[] flowers = {1, 2, 3, 4};

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] table = new List[n];
        for (int i = 0; i < n; i++) table[i] = new ArrayList<>();
        for (var p : paths) {
            table[p[0] - 1].add(p[1] - 1);
            table[p[1] - 1].add(p[0] - 1);
        }
        var ans = new int[n];
        for (int i = 0; i < n; i++) {
            var vis = new boolean[5];
            // 将与i相邻的,已经选择了种类的花园标记为true
            for (int next : table[i]) {
                vis[ans[next]] = true;
            }
            // 选择一种与相邻的3个花园不同的种类
            for (int x : flowers) {
                if (!vis[x]) { ans[i] = x; break; }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(new LC_1042().gardenNoAdj(n, paths)));
    }
}
