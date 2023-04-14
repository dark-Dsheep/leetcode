package Algorithm._记忆化DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_241 {

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression);
    }

    private List<Integer> dfs(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        var list = new ArrayList<Integer>(); // 存储中间计算结果
        var len = expression.length();
        for (var i = 0; i < len; i++) {
            var c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 递归求解表达式左半段 和表达式右半段
                List<Integer> left = dfs(expression.substring(0, i));
                List<Integer> right = dfs(expression.substring(i + 1, len));
                for (var l : left) {
                    for (var r : right) {
                        if (c == '+') list.add(l + r);
                        else if (c == '-') list.add(l - r);
                        else list.add(l * r);
                    }
                }
            }
        }
        if (list.size() == 0) { // 表达式是一个数字
            list.add(Integer.valueOf(expression));
        }
        memo.put(expression, list); // 记忆化
        return list;
    }

    public static void main(String[] args) {
        var expression = "2*3-4*5";
        System.out.println(new LC_241().diffWaysToCompute(expression));
    }
}
