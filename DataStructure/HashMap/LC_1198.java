package DataStructure.HashMap;


public class LC_1198 {

    /*
        1198. 找出所有行中最小公共元素
     */
    // 数组哈希
    public int smallestCommonElement(int[][] mat) {
        int[] map = new int[10010];
        for (int[] arr : mat) {
            for (int num : arr) {
                map[num]++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000;i ++) {
            if (map[i] == mat.length) {
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {

    }
}
