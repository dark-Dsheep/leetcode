package DataStructure.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_737 {

    // 保存父节点
    HashMap<String, String> parent = new HashMap<>();

    /*
        737. 句子相似性 II
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2,
                                          List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        for (List<String> s : similarPairs) {
            init(s);
        }
        for (List<String> s : similarPairs) {
            String a = s.get(0);
            String b = s.get(1);
            union(a, b);
        }
        for (int i = 0; i < sentence1.length; i++) {
            String a = sentence1[i];
            String b = sentence2[i];
            if (a.equals(b)) continue;
            if (isConnected(a, b)) {
                System.out.println(a + " " + b + " 有相同的父亲");
            } else {
                return false;
            }
        }
        return true;
    }

    public void init(List<String> list) {
        for (String str : list) {
            parent.put(str, str);
        }
    }

    public String find(String x) {
        if (x == null) return null;
        while (x != null && !x.equals(parent.get(x))) {
            parent.put(x, parent.get(parent.get(x))); // 路径压缩
            x = parent.get(x);
        }
        return x;
    }

    public void union(String a, String b) {
        String aRoot = find(a);
        String bRoot = find(b);
        if (aRoot == null) aRoot = a;
        if (bRoot == null) bRoot = b;
        if (aRoot.equals(bRoot)) return;
        parent.put(bRoot, aRoot);
    }

    public boolean isConnected(String a, String b) {
        String aRoot = find(a);
        String bRoot = find(b);
        if (aRoot == null && bRoot == null) return false;
        if (aRoot == null || bRoot == null) return false;
        return aRoot.equals(bRoot);
    }

    public static void main(String[] args) {
        String[] sentence1 = {"I","love","leetcode"};
        String[] sentence2 = {"I","love","onepiece"};
        List<List<String>> similarPairs = new ArrayList<>();
        similarPairs.add(List.of("manga","onepiece"));
        similarPairs.add(List.of("platform", "anime"));
        similarPairs.add(List.of("leetcode", "platform"));
        similarPairs.add(List.of("anime", "manga"));
        System.out.println(new LC_737().areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }
}
