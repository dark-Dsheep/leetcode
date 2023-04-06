package Competition.biweekly.bw97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1 {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            String s = String.valueOf(x);
            for (char c : s.toCharArray()) {
                list.add(c - '0');
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {13,25,83,77};
        System.out.println(Arrays.toString(new T1().separateDigits(arr)));
    }
}
