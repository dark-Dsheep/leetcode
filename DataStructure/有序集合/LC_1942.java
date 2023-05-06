package DataStructure.有序集合;

import java.util.Arrays;

public class LC_1942 {

//    1942. 最小未被占据椅子的编号

    // TODO: 2023/2/13

    public int smallestChair(int[][] times, int targetFriend) {
        Arrays.sort(times, ((o1, o2) -> o1[0] - o2[0]));

        var t = times[targetFriend];
        int s = t[0], e = t[1];

        return -1;

    }
}
