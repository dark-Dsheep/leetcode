package Competition.weekly.wr338;


import java.util.TreeSet;

public class T2 {


    static TreeSet<Integer> tset = new TreeSet<>();
    static boolean ok = false;
    static int N = 1001;

    static void getPrime() {
        if (ok) return;
        boolean[] st = new boolean[N];
        for (int i = 2; i <= N; i++) {
            if (!st[i]) {
                tset.add(i);
                for (int j = i * i; j <= N; j += i) {
                    st[j] = true;
                }
            }
        }
        ok = true;
    }


    public boolean primeSubOperation(int[] nums) {
        getPrime();
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= pre) return false;
            Integer lower = tset.lower(nums[i] - pre);
            if (lower != null) nums[i] -= lower;
            pre = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,9,6,10};
        System.out.println(new T2().primeSubOperation(nums));
    }
}
