package DataStructure.Stack;

import java.util.LinkedList;

public class LC_227 {

    /*
        227. 基本计算器 II
     */
    public int calculate(String s) {
        // 普通需要两个栈 -> 数字栈,符号栈
        // var stack1 = new LinkedList<Integer>();
        // var stack2 = new LinkedList<>();

        // 进阶: 使用一个栈,一个 preSign 保存上一个符号
        var stack = new LinkedList<Integer>();
        var preSign = '+';
        int num = 0, res = 0;
        for (var i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0') {                  // 符号的ascii码都小于'0'
                // System.out.println("c=" + c);
                num = num * 10 - '0' + c;    // 记录当前数字。先减，防溢出
            }
            if ((c < '0' && c != ' ') || i == s.length() - 1) {
                if (preSign == '+')         stack.push(num);
                else if (preSign == '-')    stack.push(-num);
                else if (preSign == '*')    stack.push(stack.pop() * num);
                else                        stack.push(stack.pop() / num);
                preSign = c;    // 保存当前符号
                num = 0;        // 数字清零
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
