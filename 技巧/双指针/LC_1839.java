package 技巧.双指针;

import java.util.HashSet;

public class LC_1839 {

    /*
        1839. 所有元音按顺序排布的最长子字符串
     */
    public int longestBeautifulSubstring(String word) {
        if (word.length() <= 1) return 0;
        int i, j = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(word.charAt(0));
        int len = 0;
        for (i = 1; i < word.length(); i++) {
            if (word.charAt(i) < word.charAt(i - 1)) {  // 非递增排列
                if (set.size() == 5) {
                    len = Math.max(len, i - j);
                }
                j = i;
                set.clear();
                set.add(word.charAt(i));
            } else {
                set.add(word.charAt(i));
            }
        }
        // 检查最后一段是否满足条件
        if (set.size() == 5) len = Math.max(len, i - j);
        return len;
    }

    public static void main(String[] args) {

        System.out.println(new LC_1839().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
