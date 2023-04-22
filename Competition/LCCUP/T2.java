package Competition.LCCUP;

import java.util.Arrays;
import java.util.HashSet;

public class T2 {


    HashSet<String> vis = new HashSet<>();

    public int adventureCamp(String[] expeditions) {
        var st = expeditions[0].split("->");
        vis.addAll(Arrays.asList(st));
        int mx = 0, ans = -1;
        for (int i = 1; i < expeditions.length; i++) {
            var t = expeditions[i].split("->");
            if (t.length == 0) continue;
            int cnt = 0;
            for (var s : t) {
                if (!vis.contains(s) && !s.equals("")) cnt++; vis.add(s); }
            if (cnt > mx) { mx = cnt; ans = i; }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] ex = {"Alice->Dex","","Dex"};
        System.out.println(new T2().adventureCamp(ex));
    }

}
