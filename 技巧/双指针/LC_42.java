package 技巧.双指针;

public class LC_42 {

//    42. 接雨水
    public int trap(int[] h) {
        int ans = 0, l = 0, r = h.length - 1;
        int preMax = 0, sufMax = 0;
        while (l <= r) {
            preMax = Math.max(preMax, h[l]);
            sufMax = Math.max(sufMax, h[r]);
            ans += preMax < sufMax ? preMax - h[l++] : sufMax - h[r--];
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new LC_42().trap(nums));
    }
}
