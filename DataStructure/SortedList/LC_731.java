package DataStructure.SortedList;

import java.util.TreeMap;

public class LC_731 {

    static class MyCalendarTwo {
        static int max = (int) 1e9 + 1;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        public MyCalendarTwo() {
            tmap.put(-1, -1);
            tmap.put(max, max);
        }

        public boolean book(int start, int end) {
            int lo = tmap.floorKey(start);
            int hi = tmap.ceilingKey(start);
            if (hi < end && tmap.get(lo) > start) {
                int lend = tmap.get(lo);
                int hend = tmap.get(hi);
                // 判断lo hi区间相交
                int k = Math.min(lend, hend) - Math.max(lo, hi);
            }
            tmap.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo mct = new MyCalendarTwo();
        mct.book(10, 20);
        mct.book(50, 60);
        System.out.println(mct.book(10, 40));
    }
}
