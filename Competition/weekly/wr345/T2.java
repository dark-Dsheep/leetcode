package Competition.weekly.wr345;

public class T2 {


    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        for (int j : derived) {
            if (j == 1) ans++;
        }
        return ans % 2 == 0;
    }

    public static void main(String[] args) {

    }
}
