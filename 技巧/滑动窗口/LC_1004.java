package 技巧.滑动窗口;

public class LC_1004 {

//    1004. 最大连续1的个数 III

    public int longestOnes(int[] nums, int k) {
        var count = new int[2];
        int maxCnt = 0;
        int i = 0, j = 0;
        int ans = 0;
        while (i < nums.length) {
            count[nums[i]]++;
            if (nums[i] == 1) {
                maxCnt = Math.max(maxCnt, count[nums[i]]);
            }
            if (i - j + 1 > maxCnt + k) { // 缩小窗口
                count[nums[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
}
