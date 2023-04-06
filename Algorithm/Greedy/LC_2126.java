package Algorithm.Greedy;

import java.util.Arrays;

public class LC_2126 {

//    2126. 摧毁小行星
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int x : asteroids) {
            if (x > m) return false;
            m += x;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
