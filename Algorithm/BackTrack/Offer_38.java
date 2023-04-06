package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer_38 {

    //剑指 Offer 38. 字符串的排列
    private List<String> res = new ArrayList<>();
    private boolean[] used = new boolean[8];

    // 类似题目 LC47. 全排列II
    public String[] permutation(String s) {
        char[] data = s.toCharArray();
        Arrays.sort(data);
        var path = new StringBuilder();
        dfs(data, path);
//        System.out.println(res);
        return res.toArray(String[]::new);
    }

    private void dfs(char[] data, StringBuilder path) {
        if (path.length() == data.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < data.length; i++) {
            if (used[i]) continue;
            if (i > 0 && data[i] == data[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.append(data[i]);
            dfs(data, path);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {

    }
}
