package DataStructure.Stack;

import java.util.LinkedList;

public class LC_1190 {

    /*
        1190. 反转每对括号间的子串
     */
    public String reverseParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                // ( a b c d )
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // 弹出 (
                for (int i = 0; i < sb.length(); i++) {
                    stack.push(sb.charAt(i));
                }
            }
        }
        char[] chars = new char[stack.size()];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return String.valueOf(chars);
    }



    public static void main(String[] args) {

        String s = "vdgzyj()";
        System.out.println(new LC_1190().reverseParentheses(s));
    }
}
