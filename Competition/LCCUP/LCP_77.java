package Competition.LCCUP;

import java.util.Arrays;

public class LCP_77 {

    /**
     * LCP 77. 符文储备
     * @param runes
     * @return
     */

    public int runeReserve(int[] runes) {
        Arrays.sort(runes);
        int ans = 0;
        int pre = 1;
        for (int i = 1; i < runes.length; i++) {
            if (runes[i] - runes[i-1] <= 1) {
                pre++;
            } else {
                ans = Math.max(ans, pre);
                pre = 1;
            }
        }
        if (pre != 0) ans = Math.max(ans, pre);
        return ans;
    }

    public static void main(String[] args) {

    }
}
