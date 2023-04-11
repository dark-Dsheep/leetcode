package Algorithm.BinarySearch;

public class LC_1898 {

//    1898. 可移除字符的最大数目 Rating(1913)

    public int maximumRemovals(String s, String p, int[] rm) {
        int l = 0;
        int r = rm.length;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(s, p, rm, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    // check答案最大为mid的时候,能否满足p是s的一个子序列
    boolean check(String s, String p, int[] rm, int mid) {
        int m = s.length(), n = p.length();
        var d = new boolean[m+1];
        for (int i = 0; i < Math.min(rm.length, mid); i++) {
            d[rm[i]] = true;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (!d[i] && s.charAt(i) == p.charAt(j)) j++;
            i++;
        }
        return j == n;
    }

    public static void main(String[] args) {
        var s = "abcacb";
        var p = "ab";
        int[] rm = {3, 1, 0};
        System.out.println(new LC_1898().maximumRemovals(s, p, rm));
    }
}
