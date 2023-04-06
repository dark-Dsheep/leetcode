package Algorithm.BinarySearch;

import java.util.*;

public class LC_2080 {

//    2080. 区间内查询数字的频率

    static class RangeFreqQuery {

        Map<Integer, List<Integer>> map; // 保存value的所在下标

        public RangeFreqQuery(int[] arr) {
            this.map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            if (!map.containsKey(value)) return 0;
            var list = map.get(value);
            // list是有序的,使用二分查找定位下标区间
            int l = leftBound(list, left);
            int r = rightBound(list, right);
            if (l == -1 || r == -1) return 0;
            return r - l + 1;
        }

        // 查找小于等于index的最大索引
        int leftBound(List<Integer> list, int index) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= index) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (list.get(l) < index) return -1;
            return l;
        }

        // 查找大于等于index的最小索引
        int rightBound(List<Integer> list, int index) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= index) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(l) > index) return -1;
            return l;
        }

    }
    // 解法二 平衡树
    class RangeFreqQuery2 {

        private HashMap<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

        public RangeFreqQuery2(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], t -> new TreeMap<>(Map.of(-1, 0)))
                        .put(i, map.get(arr[i]).size());
            }
        }

        public int query(int left, int right, int value) {
            return map.computeIfAbsent(value, t ->
                    new TreeMap<>(Map.of(-1, 0)))
                    .floorEntry(right).getValue()
                    - map.get(value).lowerEntry(left).getValue();
        }
    }

    public static void main(String[] args) {
        RangeFreqQuery query = new RangeFreqQuery(new int[]{1, 1, 1, 2, 2});
//        System.out.println(query.query(0, 1, 2));

//        List<Integer> list = List.of(1, 3, 5, 6, 8, 9);
        int size = query.query(4, 7, -1);
        System.out.println(size);
    }
}
