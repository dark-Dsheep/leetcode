package Algorithm.Greedy;

import java.util.Arrays;

public class LC_455 {


    /*
        455. 分发饼干

     */
    public int findContentChildren(int[] g, int[] s) {
        // 贪心策略： 让更多的孩子吃到饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }



    public static void main(String[] args) {

    }
}
