package Algorithm.DP;

public class LC_05 {


    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 1;
        var ans = "";
        for (int i = 1; i < n; i++) {
            var x = s.charAt(i);
            int l = i, r = i;
            while (l >= 0 && s.charAt(l) == x) l--;
            while (r < n && s.charAt(r) == x) r++;
            while ((l >= 0 && r < n) && (s.charAt(l) == s.charAt(r))) {
                l--;
                r++;
            }
            if (r - l + 1 > maxLen) {
                ans = s.substring(l+1, r);
                maxLen = r - l + 1;
            }
        }
        return ans;

    }


    public static void main(String[] args) {

    }
}
