package 技巧.前缀和;

import java.util.HashMap;

public class LC_1442 {

    /*
        1442. 形成两个异或相等数组的三元组数目
     */

    // TODO 前缀异或 后缀异或
    public int countTriplets(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; i++) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            pre = pre ^ arr[i];
            System.out.println("i -> " + i + " pre=" + pre);
        }
        System.out.println(new LC_1442().countTriplets(arr));
    }
}
