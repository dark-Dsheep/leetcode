package Algorithm.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class LC_1187 {

    TreeSet<Integer> tset = new TreeSet<>();
    HashMap<Integer, Integer>[] f = new HashMap[2010];
    int[] a;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        a = arr1;
        for (int x : arr2) tset.add(x);
        Arrays.setAll(f, e -> new HashMap<>());
        int ans = dfs(a.length - 1, 0x3f3f3f3f);
        return ans == 0x3f3f3f3f ? -1 : ans;
    }
    // 枚举选不选
    int dfs(int i, int pre) {
        if (i < 0) return 0;
        if (f[i].containsKey(pre))
            return f[i].get(pre);
        int ans = 0x3f3f3f3f;
        if (a[i] < pre)
            ans = Math.min(ans, dfs(i - 1, a[i]));
        // 从b中选择一个 小于pre的最大数字
        Integer x = tset.lower(pre);
        if (x != null)
            ans = Math.min(ans, 1 + dfs(i - 1, x));
        f[i].put(pre, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {4, 3, 1};
        System.out.println(new LC_1187().makeArrayIncreasing(arr1, arr2));
    }
}
