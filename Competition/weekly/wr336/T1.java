package Competition.weekly.wr336;

public class T1 {

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (check(words[i].charAt(0)) && check(words[i].charAt(words[i].length() - 1))) {
                ans++;
            }
        }
        return ans;
    }

    boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    public static void main(String[] args) {

    }
}
