package Algorithm.TopoSort;

import java.util.*;

public class LC_2115 {

    //2115. 从给定原材料中找到所有可以做出的菜

    HashMap<String, Integer> rd = new HashMap<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashMap<String, List<String>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                var k = ingredients.get(i).get(j);
                g.computeIfAbsent(k, v -> new ArrayList<>());
                g.get(k).add(recipes[i]);
                rd.merge(recipes[i], 1, Integer::sum);  // rec[i]入度++
            }
        }
        var q = new LinkedList<String>();
        for (var s : supplies) q.offer(s); // 初始材料入度为0
        var ans = new ArrayList<String>();
        // ===========TopSort==============
        while (q.size() > 0) {
            var p = q.poll();
            if (!g.containsKey(p)) continue;
            for (var nxt : g.get(p)) {
                rd.merge(nxt, -1, Integer::sum);
                if (rd.get(nxt) == 0) {
                    q.offer(nxt);
                    ans.add(nxt);
                }
            }
        }
        // ===========TopSort==============
        return ans;
    }

    public static void main(String[] args) {
        String[] rec = {"bread"};
        ArrayList<List<String>> ingred = new ArrayList<>();
        ingred.add(List.of("yeast", "flour"));
        String[] supplies = {"yeast","flour","corn"};
        System.out.println(new LC_2115().findAllRecipes(rec, ingred, supplies));
    }
}
