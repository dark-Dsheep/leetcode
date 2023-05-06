package 技巧.双指针;

import java.util.Arrays;

public class LC_2410 {

    /*
        2410. 运动员和训练师的最大匹配数
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        var i = 0;
        var j = 0;
        var res = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
