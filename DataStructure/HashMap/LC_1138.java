package DataStructure.HashMap;

import java.util.HashMap;

public class LC_1138 {

    /*
        1138. 字母板上的路径
     */
    static HashMap<Character, int[]> map = new HashMap<>() {
        {
            put('a', new int[]{0, 0});
            put('b', new int[]{0, 1});
            put('c', new int[]{0, 2});
            put('d', new int[]{0, 3});
            put('e', new int[]{0, 4});
            put('f', new int[]{1, 0});
            put('g', new int[]{1, 1});
            put('h', new int[]{1, 2});
            put('i', new int[]{1, 3});
            put('j', new int[]{1, 4});
            put('k', new int[]{2, 0});
            put('l', new int[]{2, 1});
            put('m', new int[]{2, 2});
            put('n', new int[]{2, 3});
            put('o', new int[]{2, 4});
            put('p', new int[]{3, 0});
            put('q', new int[]{3, 1});
            put('r', new int[]{3, 2});
            put('s', new int[]{3, 3});
            put('t', new int[]{3, 4});
            put('u', new int[]{4, 0});
            put('v', new int[]{4, 1});
            put('w', new int[]{4, 2});
            put('x', new int[]{4, 3});
            put('y', new int[]{4, 4});
            put('z', new int[]{5, 0});
        }
    };

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int curx = 0, cury = 0;
        for (char c : target.toCharArray()) {
            int[] point = map.get(c);
            int x = point[0], y = point[1];
            // 判断x y在cur的什么方向
            if (x == curx && y == cury) {
                sb.append('!');
                continue;
            }
            int upCnt = 0, downCnt = 0, leftCnt = 0, rightCnt = 0;
            if (x == 5 && (cury != y)) {                    // 下一个点是z 特判
                leftCnt = cury;
                downCnt += (x - curx);
                while (leftCnt-- > 0) sb.append('L');
                while (downCnt-- > 0) sb.append('D');
            } else if (curx == 5 && (cury != y)) {         // 当前点是z 特判
                upCnt += (curx - x);
                rightCnt = y;
                while (upCnt-- > 0) sb.append('U');
                while (rightCnt-- > 0) sb.append('R');
            } else {
                if (x > curx) {
                    downCnt += (x - curx);
                } else {
                    upCnt += (curx - x);
                }
                if (y > cury) {
                    rightCnt += (y - cury);
                } else {
                    leftCnt += (cury - y);
                }
                if (leftCnt != 0) {  // 左
                    while (leftCnt-- > 0) sb.append('L');
                } else {                    // 右
                    while (rightCnt-- > 0) sb.append('R');
                }
                if (upCnt != 0) {           // 上
                    while (upCnt-- > 0) sb.append('U');
                } else {                    // 下
                    while (downCnt-- > 0) sb.append('D');
                }
            }
            sb.append('!');
            curx = x;
            cury = y;
        }
        return sb.toString();
    }

    // 0x3f
    public String alphabetBoardPath2(String target) {
        var ans = new StringBuilder();
        int x = 0, y = 0;
        for (var c : target.toCharArray()) {
            // 计算出下一个目标点
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            var v = nx < x ? "U".repeat(x - nx) : "D".repeat(nx - x);
            var h = ny < y ? "L".repeat(y - ny) : "R".repeat(ny - y);
            // 如果要移动到'z',必须先水平移动,再竖直移动
            ans.append(c != 'z' ? v + h : h + v).append("!");
            x = nx;
            y = ny;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        // "DDDDD!UUUUURRR!DDDDLLLD!"
        String target = "zb";
        System.out.println(new LC_1138().alphabetBoardPath(target));
    }
}
