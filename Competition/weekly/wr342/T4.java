package Competition.weekly.wr342;


public class T4 {


    public int minOperations(int[] nums) {
        return -1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] a = {1, 1};
        System.out.println(new T4().minOperations(a));
    }
}
