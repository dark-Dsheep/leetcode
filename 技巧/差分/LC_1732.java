package 技巧.差分;

import java.util.TreeSet;

public class LC_1732 {


//    1732. 找到最高海拔

    public int largestAltitude(int[] gain) {
        // 差分数组的前缀和 是原数组
        int s = 0, ans = 0;
        for (int x : gain) {
            s += x;
            ans = Math.max(ans, s);
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<Integer>();
//        tset.higher()
    }
}
