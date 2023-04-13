package HardEX;

public class LC_564 {

    public String nearestPalindromic(String n) {
        long max = (long) (1e18-1);
        long i, j, k = Long.parseLong(n);
        i = j = k;
        while (i > 0 && j < max) {
            var a = String.valueOf(--i);
            var b = String.valueOf(++j);
            var f1 = check(a);
            var f2 = check(b);
            if (f1 && f2) {
                long x = Math.abs(k - i);
                long y = Math.abs(k - j);
                if (x <= y) return String.valueOf(Math.min(i, j));
                else return b;
            } else if (f1) {
                return a;
            } else if (f2) {
                return b;
            }
        }
        return "0";
    }

    boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var n = "1";
        System.out.println(new LC_564().nearestPalindromic(n));
    }
}
