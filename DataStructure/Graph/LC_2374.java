package DataStructure.Graph;

public class LC_2374 {

    /*
        2374. 边积分最高的节点
     */
    public int edgeScore(int[] edges) {
        long[] map = new long[100010];

        for (int i = 0; i < edges.length; i++) {
            int to = edges[i];
            map[to] += i;
        }
        long score = -1;
        int res = -1;
        // System.out.println(Arrays.toString(map));
        for (int i = 0; i < edges.length; i++) {
            if (map[i] > score) {
                score = map[i];
                res = i;
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
