package Competition.weekly.wr343;

public class T4 {


    public String smallestBeautifulString(String s, int k) {
        char[] c = s.toCharArray();
        c[s.length() - 1]++;
        for (int i = s.length() - 1; i < s.length(); ) {
            if (c[i] == 'a' + k) {
                c[i--] = 'a';
                if (i < 0) {
                    return "";
                }
                c[i]++;
            } else if (i > 0 && c[i] == c[i-1] || i > 1 && c[i] == c[i-2]) {
                c[i]++;
            } else {
                i++;
            }
        }
        return String.valueOf(c);
    }
}
