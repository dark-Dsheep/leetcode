package Competition.weekly.wr325;

public class T4 {

//    好分区的数目

//    给你一个正整数数组 nums 和一个整数 k 。
//
//    分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区。
//
//    返回 不同 的好分区的数目。由于答案可能很大，请返回对 109 + 7 取余 后的结果。
//
//    如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。

    public int countPartitions(int[] nums, int k) {
        int dp[][] = new int[nums.length + 1][k], sum = 0, result = 1;
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 2;
        }
        for (int i = 0; i < nums.length; i++) {
            sum = Math.min(k * 2, sum + nums[i]);
            result = result * 2 % 1000000007;
            for (int j = 1; j < k; j++) {
                dp[i + 1][j] = (dp[i][j] + (j < nums[i] ? 0 : dp[i][j - nums[i]])) % 1000000007;
            }
        }
        for (int i = 0; i < k; i++) {
            result = (result + 1000000007 - dp[nums.length][i]) % 1000000007;
        }
        return sum < k * 2 ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        System.out.println(new T4().countPartitions(nums, k));
    }
}
