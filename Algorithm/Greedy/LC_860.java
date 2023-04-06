package Algorithm.Greedy;

public class LC_860 {

    /*
        860. 柠檬水找零
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int x : bills) {
            if (x == 5) {
                five += 1;
                continue;
            }
            if (x == 10) {
                // 需要一张5元
                if (five == 0) return false;
                five -= 1;
                ten += 1;
            } else {
                // 需要一张10元和5元
                if (ten != 0 && five != 0) {
                    ten -= 1;
                    five -= 1;
                    continue;
                }
                // 或者3张5元
                if (five >= 3) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,20,5,10,5,20};
        System.out.println(new LC_860().lemonadeChange(bills));
    }
}
