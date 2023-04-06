package Competition.weekly.wr337;

import java.util.HashMap;

public class T3 {
    // 1.回溯 + 剪枝

    // 2.dp

    int ans = -1;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, 0, k);
        return ans;
    }

    void dfs(int[] nums, int i, int k) {
        if (i >= nums.length) {
            ans += 1;
            return;
        }
        // 不选
        dfs(nums, i + 1, k);
        // 选
        int x = nums[i];
        if (!map.containsKey(x - k) && !map.containsKey(x + k)) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            dfs(nums, i + 1, k);
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) map.remove(x);
        }
    }




    public static void main(String[] args) {
        int[] nums = {942, 231, 247, 267, 741, 320, 844, 276, 578, 659, 96, 697, 801, 892, 752, 948, 176, 92, 469, 595};
        int k = 473;
        System.out.println(new T3().beautifulSubsets(nums, k));
    }
}
