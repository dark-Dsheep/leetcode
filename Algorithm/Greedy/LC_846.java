package Algorithm.Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class LC_846 {


    /*
        846. 一手顺子
     */

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand); // 排序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int cur : hand) {
            if (map.get(cur) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (!map.containsKey(cur + i) || map.get(cur + i) <= 0) { // 不存在牌 或者牌不够凑成顺子
                        return false;
                    }
                    map.put(cur + i, map.get(cur + i) - 1); // 使用一张牌 数量-1
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(new LC_846().isNStraightHand(hand, groupSize));
        System.out.println(Integer.parseInt("1111", 2));
    }
}
