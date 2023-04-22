package Competition.LCCUP;


import java.util.ArrayList;
import java.util.Arrays;

public class T1 {

    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length, m = n / 2;
        int k = n - m;
        var list = new ArrayList<Integer>();
        for (int x : supplies) list.add(x);
        while (k-- > 0) {
            int sz = list.size();
            int x = 0, y = 0;
            int mi = Integer.MAX_VALUE;
            for (int i = 0; i < sz; i++) {
                if (i + 1 < sz) {
                    int v = list.get(i) + list.get(i+1);
                    if (mi > v) { x = i; y = i+1; mi = v; }
                }
            }
            for (int i = 0; i < sz; i++) {
                if (i == x) {
                    list.add(i, mi);
                    if (x + 1 < sz) list.remove(x+1);
                    if (y < sz) list.remove(y);
                }
            }
        }
        var ans = new int[m];
        for (int i = 0; i < m; i++) { ans[i] = list.get(i); }
        return ans;
    }

    public static void main(String[] args) {
        int[] s = {7, 3, 6, 1, 8};
        System.out.println(Arrays.toString(new T1().supplyWagon(s)));
    }
}
