package Skill.DoublePointer;

public class LC_2105 {

    /*
        2105. 给植物浇水 II
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0, r = plants.length - 1;
        int A = capacityA, B = capacityB;
        int cnt = 0;
        while (l < r) {
            if (A < plants[l]) {
                A = capacityA;
                cnt += 1;
            }
            if (B < plants[r]) {
                B = capacityB;
                cnt += 1;
            }
            A -= plants[l];
            B -= plants[r];
            l++;
            r--;
        }
        if (l == r) {
            if (A < B) {
                if (B < plants[r]) cnt += 1;
            } else {
                if (A < plants[l]) cnt += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
