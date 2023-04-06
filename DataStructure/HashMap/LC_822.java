package DataStructure.HashMap;

import java.util.HashSet;

public class LC_822 {

    /*
        822. 翻转卡片游戏
     */
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) { // 正反面相同的不能选择
                set.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        // 剩下数字中找最小的
        for (int x : fronts) {
            if (!set.contains(x)) {
                res = Math.min(res, x);
            }
        }
        for (int x : backs) {
            if (!set.contains(x)) {
                res = Math.min(res, x);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] fronts = {1, 2, 4, 4, 7};
        int[] backs = {1, 3, 4, 1, 3};
        System.out.println(new LC_822().flipgame(fronts, backs));
    }
}
