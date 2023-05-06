package Algorithm.DP;

public class LC_526 {

//    526. 优美的排列 TODO

    public int countArrangement(int n) {
        int mask = 1 << n;
        var dp = new int[n][mask];
        for (int s = 0; s < mask; s++) { // 遍历状态
            int ns = s;
            for (int k = 1; k <= n; k++) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 15);
    }
}
