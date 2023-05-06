package 数论;

public class LC_789 {


//    789. 逃脱阻碍者

    //曼哈顿距离公式: dist(A,B)= |x1 - x2| + |y1 - y2|

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x = target[0], y = target[1];
        var dist = Math.abs(x) + Math.abs(y);
        for (var g : ghosts) {
            int x1 = g[0], y1 = g[1];
            var gDist = Math.abs(x1 - x) + Math.abs(y1 - y);
            // 鬼到终点的距离比 人到终点的距离短 判定输
            if (gDist <= dist) return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
