package Algorithm.Bfs;


import java.util.Arrays;

public class LC_1663 {

    /*
        1663. 具有给定数值的最小字符串
        TODO
     */

    public String getSmallestString(int n, int k) {
        // 贪心
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        k -= n;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= 25) {
                k -= 25;
                chars[i] = 'z';
            } else {
                chars[i] = (char) ('a' + k);
                k -= k;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new LC_1663().getSmallestString(3, 27));
    }
}
