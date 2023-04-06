package Competition.biweekly.bw97;

import java.util.HashSet;

public class T2 {


    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : banned) set.add(x);
        int cnt = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            sum += i;
            if (sum > maxSum) break;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
