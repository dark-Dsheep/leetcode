package Competition.biweekly.bw86;

public class T2 {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n-2; i++) {
            String s = Integer.toUnsignedString(n, i);
            if (!check(s)) return false;
        }
        return true;
    }

    boolean check(String s) {
        int i = 0, j = s.length() -1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
