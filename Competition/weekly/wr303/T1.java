package Competition.weekly.wr303;

public class T1 {

    public char repeatedCharacter(String s) {
        var ans = ' ';
        var map = new int[26];
        for (char c : s.toCharArray()) {
            if (++map[c-'a'] == 2) return c;
        }
        return ans;
    }
}
