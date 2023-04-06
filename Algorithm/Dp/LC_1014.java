package Algorithm.Dp;

public class LC_1014 {

//    1014. 最佳观光组合
    public int maxScoreSightseeingPair(int[] v) {
        int n = v.length;
        int leftMax = v[0];
        int ans = 0;
        // v[i] + v[j] + i - j => v[i] + i + v[j] - j
        // v[i] + i可以看作左边的最大值 leftMax
        // 我们迭代遍历j 答案等价于 ans = max(ans, leftMax + v[j] - j)
        // 并且在迭代的过程中我们需要不断更新 leftMax
        for (int j = 1; j < n; j++) {
            ans = Math.max(ans, leftMax + v[j] - j);
            leftMax = Math.max(leftMax, v[j] + j);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
