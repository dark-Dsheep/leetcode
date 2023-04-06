package Competition.weekly.wr337;

public class T1 {

    public int[] evenOddBit(int n) {
//        String s = Integer.toBinaryString(n);
//        int a = 0, b = 0;
//        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
//            if (s.charAt(i) == '1' && j % 2 == 0) a++;
//            else if (s.charAt(i) == '1' && j % 2 == 1) b++;
//        }
//        return new int[]{a, b};
        int[] ans = {0, 0};
        int i = 0;
        while (n > 0) {
            ans[i] += (n & 1);
            n >>= 1;
            i ^= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 17;
    }
}
