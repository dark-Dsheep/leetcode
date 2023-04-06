package Competition.biweekly.bw83;

public class T1 {

    public String bestHand(int[] ranks, char[] suits) {
        int rcnt = 0;
        int scnt = 0;
        int[] map1 = new int[14];
        int[] map2 = new int[26];
        for (int x : ranks) {
            map1[x]++;
        }
        for (char c : suits) {
            map2[c-'a']++;
        }
        for (int i = 1; i <= 13; i++) {
            rcnt = Math.max(rcnt, map1[i]);
        }
        for (int i = 0; i < 26; i++) {
            scnt = Math.max(scnt, map2[i]);
        }
        if (scnt >= 5) return "Flush";
        else if (rcnt >= 3) return "Three of a Kind";
        else if (rcnt >= 2) return "Pair";
        return "High Card";
    }
}
