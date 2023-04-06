package Competition.weekly.wr308;

public class T2 {


    public String removeStars(String s) {
        var ans = new StringBuilder();
        var ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '*') {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(ss[i]);
            }
        }
        return ans.toString();
    }
}
