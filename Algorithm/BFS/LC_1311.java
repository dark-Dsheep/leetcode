package Algorithm.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LC_1311 {

//    1311. 获取你好友已观看的视频

    boolean[] vis = new boolean[110];
    LinkedList<Integer>[] table;
    HashMap<Integer, List<String>> map = new HashMap<>();
    HashMap<String, Integer> rankMap = new HashMap<>();

    public List<String> watchedVideosByFriends(List<List<String>> wv, int[][] friends, int id, int level) {
        table = new LinkedList[wv.size()];
        for (int i = 0; i < wv.size(); i++) {
            map.put(i, wv.get(i));
            table[i] = new LinkedList<>();
        }
        for (int i = 0; i < friends.length; i++) {
            for (int next : friends[i]) {
                table[i].add(next);
            }
        }
        // 跑一遍bfs到level层 记录视频和观看频率
        bfs(id, level);
        var ans = new ArrayList<>(rankMap.entrySet());
        // 排个序
        ans.sort(((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue() - o2.getValue();
        }));
        return ans.stream().map(e -> e.getKey()).collect(Collectors.toList());
    }

    void bfs(int id, int level) {
        var q = new LinkedList<Integer>();
        q.offer(id);
        vis[id] = true;
        while (!q.isEmpty() && level > 0) {
            int n = q.size();
            level--;
            while (n-- > 0) {
                int p = q.poll();
                for (int next : table[p]) {
                    if (!vis[next]) {
                        vis[next] = true;
                        if (level == 0) {
                            for (var video : map.get(next)) {
                                rankMap.put(video, rankMap.getOrDefault(video, 0) + 1);
                            }
                        }
                        q.offer(next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> wv = new ArrayList<>();
        wv.add(List.of("A", "B"));
        wv.add(List.of("C"));
        wv.add(List.of("B", "C"));
        wv.add(List.of("D"));
        int[][] friends = {{1, 2}, {0,3}, {0,3}, {1, 2}};
        int id = 0;
        int level = 1;
        System.out.println(new LC_1311().watchedVideosByFriends(wv, friends, id, level));
    }
}
