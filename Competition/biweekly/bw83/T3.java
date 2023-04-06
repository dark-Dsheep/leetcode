package Competition.biweekly.bw83;

import java.util.*;

public class T3 {

    // 平衡树做法
    class NumberContainers {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        public NumberContainers() {
        }

        public void change(int index, int number) {
            if (idxMap.containsKey(index)) {
                Integer x = idxMap.get(index);
                map.get(x).remove(index);
            }
            idxMap.put(index, number);
            map.computeIfAbsent(number, v -> new TreeSet<>());
            map.get(number).add(index);
        }

        public int find(int number) {
            var tset = map.get(number);
            if (tset == null || tset.size() < 1) return -1;
            return tset.first();
        }
    }
    // 懒堆删除
    class NumberContainersA {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Queue<Integer>> ms = new HashMap<>();

        public void change(int index, int number) {
            m.put(index, number);
            ms.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index); // 直接添加新数据，后面 find 再删除旧的
        }

        public int find(int number) {
            var q = ms.get(number);
            if (q == null) return -1;
            while (!q.isEmpty() && m.get(q.peek()) != number) q.poll();
            return q.isEmpty() ? -1 : q.peek();
        }
    }


}
