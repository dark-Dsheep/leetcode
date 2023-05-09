package 困难题训练;

public class LC_1449 {

//    1449. 数位成本和为目标值的最大数字 Rating(1927)

    int[] cs = new int[10];
    String[] memo = new String[5001];

    public String largestNumber(int[] cost, int target) {
        for (int i = 0; i < 9; i++) {
            cs[i+1] = cost[i];
        }
        return dfs(target);
    }

    String dfs(int t) {
        if (t == 0) return "";
        if (t < 0) return "0";
        if (memo[t] != null) return memo[t];
        var ans = "0";
        for (int i = 1; i <= 9; i++) {
            var ret = dfs(t-cs[i]);
            var v = i + ret;
            if (!ret.equals("0")) {
                if (ans.length() != v.length()) {
                    ans = ans.length() > v.length() ? ans : v;
                } else {
                    ans = ans.compareTo(v) >= 0 ? ans : v;
                }
            }
        }
        return memo[t] = ans;
    }



    public static void main(String[] args) {
        int[] cost = {4,3,2,5,6,7,2,5,5};
        int t = 9;
        System.out.println(new LC_1449().largestNumber(cost, t));
    }
}
