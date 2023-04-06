package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_890 {

    /*
        890. 查找和替换模式
     */

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // 从word -> pattern 的每个字符只能映射1次，从pattern -> word也是

        List<String> res = new ArrayList<>();
        for (String word : words) {
            int[] map = new int[130];           // 记录word[i] 与pattern[i]的映射关系
            boolean[] vis = new boolean[130];   // 记录当前字符是否已经被映射
            boolean flag = true;
            Arrays.fill(map, -1);
            for (int i = 0; i < pattern.length() && flag; i++) {
                char c1 = word.charAt(i);
                char c2 = pattern.charAt(i);
                if (map[c1] == -1 && !vis[c2]) {
                    // 将w[i]映射->p[i];
                    map[c1] = c2;
                    vis[c2] = true;
                } else if (map[c1] != c2) {
                    flag = false;
                }
            }
            if (flag) res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"badc","abab","dddd","dede","yyxx"};
        String pattern = "baba";
        System.out.println(new LC_890().findAndReplacePattern(words, pattern));
    }
}
