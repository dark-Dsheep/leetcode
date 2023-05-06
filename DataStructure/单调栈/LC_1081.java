package DataStructure.单调栈;

import java.util.ArrayDeque;

public class LC_1081 {


    /*
        1081. 不同字符的最小子序列
     */

    public String smallestSubsequence(String s) {
        if (s.length() < 2) return s;
        var vis = new boolean[26];
        var count = new int[26];
        for (var c : s.toCharArray()) count[c - 'a']++;
        var stack = new ArrayDeque<Character>();
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (vis[ch - 'a']) { // 前面已经入栈
                count[ch - 'a']--;
                continue;
            }
            // 贪心的弹出左侧较大的字符
            while (!stack.isEmpty() && count[stack.peek() - 'a'] > 1 &&  stack.peek() > ch) {
                char p = stack.pop();
                count[p - 'a']--;
                vis[p - 'a'] = false; // 恢复现场
            }
            stack.push(ch);
            vis[ch - 'a'] = true;
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var s = "bcabc";
        System.out.println(new LC_1081().smallestSubsequence(s));
    }
}
