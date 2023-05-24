package Competition.weekly.wr346;

public class T3 {


    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs(0, String.valueOf(i * i), 0, i)) {
                ans += i * i;
            }
        }
        return ans;
    }

    boolean dfs(int i, String s, int sum, int target) {
        if (sum > target) return false;
        if (i == s.length()) return sum == target;
        for (int j = i, x = 0; j < s.length(); j++) {
            x = x * 10 + s.charAt(j) - '0';
            if (dfs(j + 1, s, sum + x, target)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
    }
}
