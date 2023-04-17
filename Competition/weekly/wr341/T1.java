package Competition.weekly.wr341;

public class T1 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        var ans = new int[2];
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            int ct = 0;
            for (int x : mat[i]) { if (x == 1) ct++; }
            if (ct > max) { ans[0] = i; ans[1] = ct; max = ct;}
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
