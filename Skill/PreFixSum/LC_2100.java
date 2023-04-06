package Skill.PreFixSum;

import java.util.ArrayList;
import java.util.List;

public class LC_2100 {

    //2100. 适合打劫银行的日子

    public List<Integer> goodDaysToRobBank(int[] s, int time) {
        int n = s.length;
        var ans = new ArrayList<Integer>();
        // a[i]表示第i天前的连续递减数目
        // b[i]表示第i天后的连续递增数目
        int[] a = new int[n], b = new int[n];
        for (int i = 1; i < n; i++) {
            if (s[i] <= s[i - 1]) a[i] = a[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s[i] <= s[i + 1]) b[i] = b[i + 1] + 1;
        }
        for (int i = time; i < n; i++) {
            if (a[i] >= time && b[i] >= time) ans.add(i);
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        return ans;

    }

    public static void main(String[] args) {

    }
}
