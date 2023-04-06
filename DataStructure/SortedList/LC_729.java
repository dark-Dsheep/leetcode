package DataStructure.SortedList;

import java.util.ArrayList;
import java.util.TreeMap;

public class LC_729 {

//    729. 我的日程安排表 I

    // 暴力
    class MyCalendar {

        ArrayList<int[]> list = new ArrayList<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            for (int i = 0; i < list.size(); i++) {
                int lo = list.get(i)[0], hi = list.get(i)[1];
                int k = Math.min(end, hi) - Math.max(start, lo); // 区间求交集
                if (k > 0) return false;
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
    // 有序集合
    static class MyCalendar2 {
        static int max = (int) 1e9 + 1;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        public MyCalendar2() {
            tmap.put(-1, -1);
            tmap.put(max, max);
        }

        public boolean book(int start, int end) {
            int lo = tmap.floorKey(start);     // 左边
            int hi = tmap.ceilingKey(start);   // 右边
            if (hi < end || tmap.get(lo) > start) return false; // 判断最近的左右两个区间交集
            tmap.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
