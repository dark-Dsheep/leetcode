package Competition.weekly.wr327;

public class T1 {


    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int x : nums) {
            if (x < 0) neg++;
            if (x > 0) pos++;
        }
        return Math.max(neg, pos);
    }

    public static void main(String[] args) {

    }
}
