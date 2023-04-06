package Skill.DoublePointer;

public class LC_125 {


//    125. 验证回文串
    public boolean isPalindrome(String s) {
        if (" ".equals(s)) return true;
        s = s.toLowerCase();
        var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (check(c)) sb.append(c);
        }
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i++) != sb.charAt(j--)) return false;
        }
        return true;
    }

    boolean check(char c) {
        return (c >= 97 && c <= 125) || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {

    }
}
