package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2001 {

    /*
        2001. 可互换矩形的组数
     */

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            double key = rectangles[i][0] / (double) rectangles[i][1];
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }
        long cnt = 0;
        for (int i = 0; i < rectangles.length; i++) {
            double key = rectangles[i][0] / (double) rectangles[i][1];
            cnt += map.get(key);
        }
        return (cnt - rectangles.length) / 2; // 容斥处理
    }

    public static void main(String[] args) {
        int[][] rectangles = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
//        int[][] rectangles = {{4, 5}, {7, 8}};
        System.out.println(new LC_2001().interchangeableRectangles(rectangles));
    }
}
