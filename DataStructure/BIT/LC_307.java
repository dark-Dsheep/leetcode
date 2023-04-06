package DataStructure.BIT;

public class LC_307 {

    //    307. 区域和检索 - 数组可修改
    class NumArray {
        int[] tree;
        int[] nums;
        int n;

        public NumArray(int[] _nums) {
            nums = _nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) add(i + 1, nums[i]);
        }

        int lowbit(int x) {
            return x & -x;
        }

        // 查询前缀和
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        // 在树状数组x位置增加值u
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }

        // 区间修改
        void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        // 区间和
        int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
    }


    public static void main(String[] args) {

    }
}
