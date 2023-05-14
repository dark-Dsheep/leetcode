package Competition.weekly.wr345;

import java.util.ArrayList;

public class T1 {


    public int[] circularGameLosers(int n, int k) {
        int[] count = new int[100];
        int cur = 0, base = 1;
        count[cur]++;
        while (count[cur] < 2) {
            cur += base * k;
            if (cur >= n) cur %= n;
            count[cur]++;
            base++;
        }
        var list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (count[i-1] == 0) list.add(i);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
