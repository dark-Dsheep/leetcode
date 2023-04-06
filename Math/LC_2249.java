package Math;

import java.util.Arrays;

public class LC_2249 {


    public int countLatticePoints(int[][] circles) {
        // 按照 半径 从大到小排序
        Arrays.sort(circles, ((o1, o2) -> o2[2] - o1[2]));
        // 计算x,y的上下界 在此范围内枚举 降低时间复杂度
        int maxX = 0, maxY = 0, minX = 0x3f, minY = 0x3f;
        for (var c : circles) {
            maxX = Math.max(maxX, c[0] + c[2]);
            maxY = Math.max(maxY, c[1] + c[2]);
            minX = Math.min(minX, c[0] - c[2]);
            minY = Math.min(minY, c[1] - c[2]);
        }
        int res = 0;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for (var c : circles) {
                    if (check(i, j, c[0], c[1], c[2])) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 检查点是否在圆内
    private boolean check(int x1, int y1, int x2, int y2, int r) {
        return Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) <= r * r;
    }

    public static void main(String[] args) {

        int[][] circles = {{2, 2, 2}, {3, 4, 1}};
        System.out.println(new LC_2249().countLatticePoints(circles));
    }
}
