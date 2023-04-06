package Competition.weekly.wr304;

import java.util.Arrays;

public class T2 {

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int ans = 0;
        int n = grades.length;
        for (int i = 1; ; i++) {
            if (i * (i + 1) / 2 <= n) ans = i;
            else break;
        }
        return ans;
    }
}
