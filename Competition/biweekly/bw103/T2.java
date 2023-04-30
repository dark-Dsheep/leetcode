package Competition.biweekly.bw103;

import java.util.HashSet;

public class T2 {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int cnt = 0;
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A[i], b = B[i];
            if (set2.contains(a)) cnt++;
            if (set1.contains(b)) cnt++;
            if (a == b) cnt++;
            set1.add(a); set2.add(b);
            ans[i] = cnt;
        }
        return ans;
    }
}
