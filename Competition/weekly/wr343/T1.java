package Competition.weekly.wr343;

public class T1 {

    public int isWinner(int[] a, int[] b) {
        int ret1 = a[0];
        int ret2 = b[0];
        for (int i = 1; i < a.length; i++) {
            if (i >= 2) {
                if (a[i-1] == 10 || a[i-2] == 10) {
                    ret1 += 2 * a[i];
                } else {
                    ret1 += a[i];
                }
                if (b[i-1] == 10 || b[i-2] == 10) {
                    ret2 += 2 * b[i];
                } else {
                    ret2 += b[i];
                }
            } else {
                ret1 += a[i-1] == 10 ? 2 * a[i] : a[i];
                ret2 += b[i-1] == 10 ? 2 * b[i] : b[i];
            }
        }
        if (ret1 == ret2) return 0;
        return ret1 > ret2 ? 1 : 2;
    }
}
