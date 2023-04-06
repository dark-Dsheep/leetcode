package Math;

public class LC_1823 {


    /*
        1823. 找出游戏的获胜者
     */
    // 约瑟夫环问题
    public int findTheWinner(int n, int k) {
        int res = 0;
        int[] f = new int[n + 1];
        f[0] = f[1] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = (f[i - 1] + k) % i;
        }
        return f[n] + 1;
    }
    public static void main(String[] args) {

    }
}
