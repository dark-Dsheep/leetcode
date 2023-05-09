package 困难题训练;

public class LC_1770 {

//    1770. 执行乘法运算的最大分数 Rating(2068)

    int[] a;
    int[] b;
    Integer[][] f = new Integer[1010][1010];


    public int maximumScore(int[] nums, int[] multipliers) {
        a = nums;
        b = multipliers;
        return dfs(0,nums.length-1, 0);
    }
    // f[idx][j]表示a开头取i个,末尾取j个的最大得分 => j = len(a) - idx
    int dfs(int i, int j, int idx) {
        if (idx >= b.length) return 0;
        if (f[i][a.length-j] != null) {
            return f[i][a.length-j];
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, a[i] * b[idx] + dfs(i+1, j, idx+1));
        ans = Math.max(ans, a[j] * b[idx] + dfs(i, j-1, idx+1));
        return f[i][a.length-j] = ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        System.out.println(new LC_1770().maximumScore(nums, multipliers));
    }
}
