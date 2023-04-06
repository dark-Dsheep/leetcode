package Competition.biweekly.bw99;

import java.util.Arrays;

public class T1 {

    public int splitNum(int num) {
        var nums = String.valueOf(num).toCharArray();
        Arrays.sort(nums);
        var a = new StringBuilder();
        var b = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a.append(nums[i] - '0');
            } else {
                b.append(nums[i] - '0');
            }
        }
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
    }

    public static void main(String[] args) {
        System.out.println(new T1().splitNum(4325));
    }
}
