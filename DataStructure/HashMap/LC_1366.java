package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class LC_1366 {

    /*
        1366. 通过投票对团队排名
     */
    public String rankTeams(String[] votes) {
        // key是参赛团队, value是每场排位获得的票数
        var rankMap = new HashMap<Character, int[]>();
        for (var vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int[] rank = rankMap.getOrDefault(vote.charAt(i), new int[26]);
                rank[i]++;
                rankMap.put(vote.charAt(i), rank);
            }
        }
        var rankList = new ArrayList<>(rankMap.entrySet());
        rankList.sort(((o1, o2) -> {
            var rank1 = o1.getValue();
            var rank2 = o2.getValue();
            for (int i = 0; i < 26; i++) {
                if (rank1[i] != rank2[i]) {
                    // 根据某一场票数排序
                    return rank2[i] - rank1[i];
                }
            }
            // 票数相同则按字典序排序
            return o1.getKey() - o2.getKey();
        }));
        var sb = new StringBuilder();
        for (var e : rankList) sb.append(e.getKey());
        return sb.toString();
    }


    public static void main(String[] args) {
        var votes = new String[] {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(new LC_1366().rankTeams(votes));
    }
}
