package Competition.weekly.wr302;

public class T1 {

    public int[] numberOfPairs(int[] nums) {
        var cnt = new int[101];
        for (int x : nums) {
            cnt[x]++;
        }
        int a = 0;
        int b = 0;
        for (int x : cnt) {
            if (x != 0) {
                a += x / 2;
                if (x % 2 != 0) b++;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {

    }
}
