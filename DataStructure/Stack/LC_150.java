package DataStructure.Stack;

import java.util.LinkedList;

public class LC_150 {

    /*
        150. 逆波兰表达式求值
     */
    public int evalRPN(String[] tokens) {
        var stack = new LinkedList<Integer>();
        for (var s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                var temp = 0;
                var a = stack.pop();
                var b = stack.pop();
                System.out.println("a=" + a + " b=" + b);
                if (s.equals("+"))      temp = a + b;
                else if (s.equals("-")) temp = b - a;
                else if (s.equals("*")) temp = a * b;
                else                    temp = b / a;
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}
