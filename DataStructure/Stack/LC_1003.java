package DataStructure.Stack;

import java.util.LinkedList;

public class LC_1003 {

    /*
        1003. 检查替换后的词是否有效
     */

    // 解法一：字符串替换
    public boolean isValid(String s) {
        s = s.replaceAll("abc", "");
        while (s.contains("abc")) {
            s = s.replaceAll("abc", "");
        }
        if (s.equals("")) return true;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
        }
        return sb.toString().equals("abc");
    }
    // 解法二：栈
    public boolean isValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'b') stack.push(c);
            else {
                // 当前字符是c 需要弹出一组"abc"
                int cnt = 2;    // 需要弹出2个
                while (!stack.isEmpty() && cnt > 0) {
                    if (cnt == 2 && stack.peek() == 'b') {
                        stack.pop();
                        cnt--;
                    } else if (cnt == 1 && stack.peek() == 'a') {
                        stack.pop();
                        cnt--;
                    } else {
                        return false;
                    }
                }
                if (cnt != 0) return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(new LC_1003().isValid2("aaabc"));
    }
}
