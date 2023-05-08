package Competition.weekly.wr344;

public class T3 {

    public int[] colorTheArray(int n, int[][] queries) {
        var ans = new int[queries.length];
        var nums = new int[n];
        int i = 0, sum = 0;
        for (var q : queries) {
            int idx = q[0], c = q[1];
            if (nums[idx] != 0) {
                if (idx - 1 >= 0 && idx + 1 < n) {
                    if (nums[idx - 1] == nums[idx] && nums[idx + 1] == nums[idx]) {
                        sum -= 2;
                    } else if (nums[idx - 1] == nums[idx] || nums[idx + 1] == nums[idx]) {
                        sum -= 1;
                    }
                } else if (idx - 1 >= 0 && nums[idx - 1] == nums[idx]) {
                    sum -= 1;
                } else if (idx + 1 < n && nums[idx + 1] == nums[idx]) {
                    sum -= 1;
                }
            }
            nums[idx] = c;
            if (idx - 1 >= 0 && idx + 1 < n) {
                if (nums[idx - 1] == nums[idx] && nums[idx + 1] == nums[idx]) {
                    sum += 2;
                } else if (nums[idx - 1] == nums[idx] || nums[idx + 1] == nums[idx]) {
                    sum += 1;
                }
            } else if (idx - 1 >= 0 && nums[idx - 1] == nums[idx]) {
                sum += 1;
            } else if (idx + 1 < n && nums[idx + 1] == nums[idx]) {
                sum += 1;
            }
            ans[i++] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
