package Math;

public class LC_1780 {

    /*
       1780. 判断一个数字是否可以表示成三的幂的和
     */
    int[] memo = {1, 3, 9, 27, 81, 243, 729, 2189, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};

    public boolean checkPowersOfThree(int n) {
        for (int i = 14; i >= 0; i--) {
            if (memo[i] <= n && n != 0) {
                n -= memo[i];
            }
        }
        return n == 0; // 判断n能不能被3的幂减少到0
    }

    public static void main(String[] args) {

        System.out.println(new LC_1780().checkPowersOfThree(21));
    }
}
