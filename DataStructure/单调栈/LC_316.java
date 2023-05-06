package DataStructure.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_316 {

    /*
        316. 去除重复字母
     */
    int[] map = new int[26];
    boolean[] vis = new boolean[26];

    public String removeDuplicateLetters(String s) {
        if (s.length() < 2) return s;
        int n = s.length();
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 前面入过栈的不用再入栈
            if (vis[ch - 'a']) {
                map[ch - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && map[stack.peek() - 'a'] > 1 && stack.peek() > ch) {
                char p = stack.pop();
                vis[p - 'a'] = false; // 恢复现场
                map[p - 'a']--;
            }
            vis[ch - 'a'] = true;
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bbcaac";
        System.out.println(new LC_316().removeDuplicateLetters(s));
    }
}
