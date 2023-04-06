package DataStructure.HashMap;

import java.util.HashSet;

public class LC_1647 {


    /*
        1647. 字符频次唯一的最小删除次数
     */
    public int minDeletions(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int deleteCnt = 0;
        // set记录出现频次，保证唯一
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = map[i];
            while (freq > 0 && !set.add(freq)) {    // 出现出该频次 需要delete
                freq--;
                deleteCnt += 1;
            }
        }
        return deleteCnt;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new LC_1647().minDeletions(s));
    }
}
