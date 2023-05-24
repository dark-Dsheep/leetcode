package Competition.weekly.wr346;

public class T1 {


    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }
        return s.length();
    }

    public static void main(String[] args) {

    }
}
