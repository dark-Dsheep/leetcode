package Algorithm.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_1090 {

    /*
        1090. 受标签影响的最大值
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        // 贪心
        // 对标签按值分组
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            map.computeIfAbsent(labels[i], v -> new ArrayList<Integer>()).add(values[i]);
        }
        List<Integer> all = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            list.sort(((o1, o2) -> o2 - o1));
            // 从每个组取前useLimit个
            for (int i = 0; i < list.size() && i < useLimit; i++) {
                all.add(list.get(i));
            }
        }
        // 排序取前wanted个
        all.sort(((o1, o2) -> o2 - o1));
        int res = 0;
        for (int i = 0; i < all.size() && i < numWanted; i++) {
            res += all.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
