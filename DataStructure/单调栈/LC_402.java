package DataStructure.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_402 {

    /*
        402. 移掉 K 位数字
     */
    public String removeKdigits(String num, int k) {
//        if (num.length() == k) return "0";
//        int n = num.length();
//        StringBuilder sb = new StringBuilder(n - k);
//        for (int i = 0; i < n; i++) {
//            char ch = num.charAt(i);
//            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > ch) {
//                // 删除一个大的数字
//                sb.deleteCharAt(sb.length() - 1);
//                k--;
//            }
//            // 不添加前导零
//            if (sb.isEmpty() && ch == '0') continue;
//            sb.append(ch);
//        }
//        // k还不为0,删除后k位数字
//        sb.delete(Math.max(0, sb.length() - k), sb.length());
//        return sb.isEmpty() ? "0" : sb.toString();

        // **************************** 单调栈 *****************
        if (num.length() == k) return "0";
        int n = num.length();
        Deque<Character> stack = new ArrayDeque<>(n - k);
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            // 不添加前导零
            if (stack.isEmpty() && ch == '0') continue;
            stack.push(ch);
        }
        // k不为 0,删除后k位数字
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args) {

    }
}
