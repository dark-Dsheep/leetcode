package Competition.weekly.wr339;

public class T1 {

    public int findTheLongestBalancedSubstring(String s) {
        char[] cs = s.toCharArray();
        int best = 0;
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] == '1') {
                continue;
            }
            int c0 = 0;
            int c1 = 0;
            int j = i;
            while(j < cs.length && cs[j] == '0') {
                j++;
                c0++;
            }
            while(j < cs.length && cs[j] == '1') {
                j++;
                c1++;
            }
            i = j - 1;
            best = Math.max(best, Math.min(c0, c1) * 2);
        }
        return best;
    }





    public static void main(String[] args) {
        String s = "01000111";
        System.out.println(new T1().findTheLongestBalancedSubstring(s));
    }
}
