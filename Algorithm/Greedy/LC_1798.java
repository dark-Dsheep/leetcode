package Algorithm.Greedy;

import java.util.Arrays;

public class LC_1798 {

    /*
        1798. 你能构造出连续值的最大数目
     */
    public int getMaximumConsecutive(int[] coins) {
        // 1 1 3 4 10
        // c=1, m=0, c <= m+1, 构造方案 +c
        // c=1, m=1, c <= m+1, 构造方案 +c
        // c=3, m=2, c <= m+1, 构造方案 +c
        // 1,1,3 可以构造 [0,5]的整数 0,1,2,3,4,5
        // c=4, m=5.......
        Arrays.sort(coins);
        var m = 0;      // 初始只能构造出 0
        for (var c : coins) {
            if (c > m + 1) break; // coins 已排序,后面没有比c更小的数,退出循环
            m += c;               // 可以构造出区间 [0,m+c] 中所有整数
        }
        return m + 1;             // [0,m] 中有 m+1 个整数
    }

    public static void main(String[] args) {
    }


}
