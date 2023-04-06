package DataStructure.Queue;


import java.util.Arrays;

public class LC_1535 {


    /*
        1535. 找出数组游戏的赢家
     */

    public int getWinner(int[] arr, int k) {
        if (k > arr.length) {
            return Arrays.stream(arr).max().getAsInt();
        }
        int win = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length && cnt < k; i++) {
            if (win < arr[i]) {
                win = arr[i];   // 更新赢家
                cnt = 1;
            } else {
                cnt++;          // 记录连胜次数
            }
        }
        return win;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1,  3, 5, 4, 6, 7};
        int k = 2;
        System.out.println(new LC_1535().getWinner(arr, k));
    }
}
