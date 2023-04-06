package Design;

import java.util.HashMap;
import java.util.TreeSet;

public class LC_2349 {

//    2349. 设计数字容器系统

    class NumberContainers {

        HashMap<Integer, Integer> idxMap = new HashMap<>();       // 下标 数字
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>(); // 数字 数字下标有序集合

        public NumberContainers() {}

        public void change(int index, int number) {
            if (idxMap.containsKey(index)) {        // index处已经包含数字
                int oldNumber = idxMap.get(index);
                map.get(oldNumber).remove(index);   // 从oldNumber的下标有序集合中删除index
            }
            idxMap.put(index, number);
            map.computeIfAbsent(number, v -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            var tset = map.get(number);
            if (tset == null || tset.size() < 1) return -1;
            return tset.first();
        }
    }

    public static void main(String[] args) {

    }
}
