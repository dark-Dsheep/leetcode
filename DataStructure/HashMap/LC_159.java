package DataStructure.HashMap;

import java.util.HashMap;

public class LC_159 {

    /*
        159. 至多包含两个不同字符的最长子串
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // 滑动窗口
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) { // 移除窗口左边元素
                char c1 = s.charAt(l);
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) map.remove(c1);
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }

    public static void main(String[] args) {

        System.out.println(new LC_159().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
