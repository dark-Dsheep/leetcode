package Competition.biweekly.bw104;

public class T1 {


    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            int x = Integer.parseInt(s.substring(11, 13));
            ans += x > 60 ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
