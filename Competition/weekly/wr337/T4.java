package Competition.weekly.wr337;


public class T4 {

    public int findSmallestInteger(int[] nums, int m) {
        int[] map = new int[m];
        for (int x : nums) {
            int k = (x % m + m) % m;
            map[k]++;
        }
        for (int i = 0; i < 100001; i++) {
            if (map[i % m] == 0) return i;
            map[i % m]--;
        }
        return nums.length;
    }




    public static void main(String[] args) {

    }
}
