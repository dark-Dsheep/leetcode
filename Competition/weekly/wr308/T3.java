package Competition.weekly.wr308;

public class T3 {


    public int garbageCollection(String[] garbage, int[] travel) {
        int sum = 0;
        for (var s : garbage) {
            sum += s.length();
        }
        int m = 0, p = 0, g = 0;
        var ts = new int[travel.length+1];
        for (int i = 1; i <= travel.length; i++) {
            ts[i] = ts[i-1] + travel[i-1];
        }
        for (int i = 1; i < garbage.length; i++) {
            if (garbage[i].contains("M")) {
                m = ts[i];
            }
            if (garbage[i].contains("P")) {
                p = ts[i];
            }
            if (garbage[i].contains("G")) {
                g = ts[i];
            }
         }
        return sum + m + p + g;
    }
}
