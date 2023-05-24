package Competition.weekly.wr346;

public class T2 {

    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] cs = new char[n];
        int i = 0, j = n - 1;
        while (i <= j) {
            if (i == j) {
                cs[i] = s.charAt(i);
                break;
            }
            if (s.charAt(i) != s.charAt(j)) {
                cs[i] = cs[j] = s.charAt(i) > s.charAt(j) ? s.charAt(j) : s.charAt(i);
            } else {
                cs[i] = cs[j] = s.charAt(i);
            }
            i++;
            j--;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {

    }
}
