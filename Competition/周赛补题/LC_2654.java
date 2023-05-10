package Competition.周赛补题;

public class LC_2654 {

    // 2654. 使数组所有元素变成 1 的最少操作次数 【LC342-Q4】

    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0; // 记录nums中1的个数
        for (int x : nums) {
            cnt += x == 1 ? 1 : 0;
        }
        if (cnt > 0) return n - cnt; // gcd(x,1)=1 进行n-cnt次操作就能将nums变为1
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // 固定区间左端点
            int x = nums[i], sum = 0; // sum记录需要进行多少次操作才能让[l,r]区间出现1
            for (int j = i + 1; j < n; j++) { // 枚举区间右端点
                sum++;
                x = gcd(x, nums[j]);
                if (x == 1) {
                    ans = Math.min(ans, sum); // 最小化操作次数
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : n + ans - 1; // 最后需要将n-1个数变为1，所以答案就是n+ans-1
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
