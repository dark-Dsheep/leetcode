package DataStructure.HashMap;

import java.util.Arrays;

public class LC_1170 {


    /*
        1170. 比较字符串最小字母出现频次
     */

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[][] map = new int[words.length][1];
        // 预处理words的每个单词最小字典序出现频率
        for (int i = 0; i < words.length; i++) {
            map[i][0] = fs(words[i]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            int freq = fs(queries[i]); // q最小字典序字符出现频率
            for (int j = 0; j < words.length; j++) {
                if (freq < map[j][0]) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    public int fs(String str) {
        int[] map = new int[26];
        for (char c : str.toCharArray()) map[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) return map[i];
        }
        return 0;
    }


    public static void main(String[] args) {
        /*
            ["ba","a","baaa","aaabbbab","abbbb","bb","aaaababbba","babaaababb","bbb","b","aaaaa","babbbaab","bbbaaabab","bba","baabbaaab","bbabbababa","aaabbab","aaab"]
["bab","bab","bbaaaaab","aa","ab","bb","bbbaba","bb","bba","aba","ba","babbbabaab","baaabb","abaa","b","abbabbb","b","abbbba"]
         */
        String[] words = {"bab", "bab", "bbaaaaab", "aa", "ab", "bb", "bbbaba", "bb", "bba", "aba", "ba", "babbbabaab", "baaabb", "abaa", "b", "abbabbb", "b", "abbbba"};
        String[] queries = {"ba", "a", "baaa", "aaabbbab", "abbbb", "bb", "aaaababbba", "babaaababb", "bbb", "b", "aaaaa", "babbbaab", "bbbaaabab", "bba", "baabbaaab", "bbabbababa", "aaabbab", "aaab"};
        System.out.println(Arrays.toString(new LC_1170().numSmallerByFrequency(queries, words)));
    }
}
